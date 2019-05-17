
# Sudoku solver

## Naming convention

> _example for a sudoku 9*9_

```
    0   1   2   3   4   5   6   7   8  
  ╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗      ╔═══╤═══╤═══╗  
0 ║   │   │   ║   │   │   ║   │   │   ║      ║ 0 │ 1 │ 2 ║
  ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢      ╟───┼───┼───╢
1 ║  SQUARE0  ║  SQUARE1  ║  SQUARE2  ║      ║ 3 │ 4 │ 5 ║
  ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢      ╟───┼───┼───╢
2 ║   │   │   ║   │   │   ║   │   │   ║      ║ 6 │ 7 │ 8 ║
  ╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣      ╚═══╧═══╧═══╝
3 ║   │   │   ║   │   │   ║   │   │   ║    Inside each square
  ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢    cells got an index
4 ║  SQUARE3  ║  SQUARE4  ║  SQUARE5  ║
  ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
5 ║   │   │   ║   │   │   ║   │   │   ║
  ╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣
6 ║   │   │   ║   │   │   ║   │   │   ║
  ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
7 ║  SQUARE6  ║  SQUARE7  ║  SQUARE8  ║
  ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
8 ║   │   │   ║   │   │   ║   │   │   ║
  ╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝
  <----------->
    square.lenght
  <----------------------------------->
    grid.size
```

If a cell must be empty, we put its value to 0.

## Supported formats

We currently only support 9 * 9 and 16 * 16 (only console mode).

## Threads organization

```
+-----------------+          +----------------+          +-----------------+
|                 |          |                |          |                 |
|                 |          |                |          |                 |
|  MAIN THREAD    |  Create  |  GUI THREAD    |  Create  |  SOLVER THREAD  | <----+  The solver waits the
|                 | +------> |                | +------> |                 |      |  flag in the speed
|                 |          |                |          |                 |      |  locker to raise.
+-----------------+          +----------------+          +-----------------+      |
|                 |          |                |          |                 |      |  The timer raises the
| App             |          | Solver         |          | speedLocker     |      |  flag when needed.
|                 |          | Grid           |          |                 |      |
+-----------------+          |                |          +-----------------+      |  The gui also raises
                             +----------------+                                   |  the flag if mode step
                                                         +-----------------+      |  by step is active.
                                     +                   |                 |      |
                                     |      Create       |                 |      |  The gui updates the
                                     +-----------------> |  TIMER THREAD   |  <---+  speed value.
                                                         |                 |
                                                         |                 |
                                                         +-----------------+
                                                         |                 |
                                                         | Speed           |
                                                         |                 |
                                                         +-----------------+
```

