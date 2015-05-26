import org.scalatest.FlatSpec

class HanzoSpec extends FlatSpec {
    val puzzle = Array(
      0,0,6,0,0,7,3,0,0,
      0,1,8,0,0,9,0,5,0,
      5,0,0,0,0,0,0,6,4,
      9,2,0,0,8,0,0,0,0,
      0,0,0,7,6,3,0,0,0,
      0,0,0,0,9,0,0,7,5,
      6,3,0,0,0,0,0,0,8,
      0,9,0,3,0,0,5,2,0,
      0,0,2,4,0,0,6,0,0
      )
    val sudoku = new Sudoku(puzzle)
    val hanzo = new Hanzo()

  "Hanzo" should "correctly identify the neighbors of a given index" in {
    val calculatedNeighbors = hanzo.getNeighborIndices(2, 5)
    val expectedNeighbors =
      Set(
        (0,5),(1,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),//Row neighbors
        (2,0),(2,1),(2,2),(2,3),(2,4),(2,6),(2,7),(2,8),//Column neighbors
        (0,3),(1,3),(0,4),(1,4)//Section neighbors
      )
    //println(calculatedNeighbors &~ expectedNeighbors)
    assert(calculatedNeighbors == expectedNeighbors)
  }

  it should "identify the possible values for a given index" in {
    val calculatedValues = hanzo.getPossibleValuesForIndex(sudoku,0,0)
    val expectedValues = Set(2,4)
    assert(calculatedValues == expectedValues)
  }

  it should "correctly construct a row collection for the sudoku" in {
    val calculatedValue = hanzo.getAllRowIndices(sudoku)
    val expectedValue = Set(
      Set((0,0),(1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0),(8,0)),
      Set((0,1),(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1)),
      Set((0,2),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2)),
      Set((0,3),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3)),
      Set((0,4),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4)),
      Set((0,5),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5)),
      Set((0,6),(1,6),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(8,6)),
      Set((0,7),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7)),
      Set((0,8),(1,8),(2,8),(3,8),(4,8),(5,8),(6,8),(7,8),(8,8))
    )
    assert(calculatedValue == expectedValue)
  }

  it should "correctly construct a column collection for the sudoku" in {
    val calculatedValue = hanzo.getAllColumnIndices(sudoku)
    val expectedValue = Set(
      Set((0,0),(0,1),(0,2),(0,3),(0,4),(0,5),(0,6),(0,7),(0,8)),
      Set((1,0),(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8)),
      Set((2,0),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8)),
      Set((3,0),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8)),
      Set((4,0),(4,1),(4,2),(4,3),(4,4),(4,5),(4,6),(4,7),(4,8)),
      Set((5,0),(5,1),(5,2),(5,3),(5,4),(5,5),(5,6),(5,7),(5,8)),
      Set((6,0),(6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(6,8)),
      Set((7,0),(7,1),(7,2),(7,3),(7,4),(7,5),(7,6),(7,7),(7,8)),
      Set((8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7),(8,8))
    )
    assert(calculatedValue == expectedValue)
  }

  it should "correctly construct a collection of sections for the sudoku" in {
    val calculatedValue = hanzo.getAllSectionIndices(sudoku)
    val expectedValue = Set(
      Set((0,0),(1,0),(2,0),(0,1),(1,1),(2,1),(0,2),(1,2),(2,2)),
      Set((3,0),(4,0),(5,0),(3,1),(4,1),(5,1),(3,2),(4,2),(5,2)),
      Set((6,0),(7,0),(8,0),(6,1),(7,1),(8,1),(6,2),(7,2),(8,2)),
      Set((0,3),(1,3),(2,3),(0,4),(1,4),(2,4),(0,5),(1,5),(2,5)),
      Set((3,3),(4,3),(5,3),(3,4),(4,4),(5,4),(3,5),(4,5),(5,5)),
      Set((6,3),(7,3),(8,3),(6,4),(7,4),(8,4),(6,5),(7,5),(8,5)),
      Set((0,6),(1,6),(2,6),(0,7),(1,7),(2,7),(0,8),(1,8),(2,8)),
      Set((3,6),(4,6),(5,6),(3,7),(4,7),(5,7),(3,8),(4,8),(5,8)),
      Set((6,6),(7,6),(8,6),(6,7),(7,7),(8,7),(6,8),(7,8),(8,8))
    )
    assert(calculatedValue == expectedValue)
  }

  //it should "identify which cells it can immediately solve with simple elimination" in {
    //val newSudoku = hanzo.stepSolve(sudoku)
    //val expectedGrid = Array(
      //0,4,6,0,0,7,3,0,0,
      //0,1,8,0,0,9,0,5,0,
      //5,7,0,0,0,0,0,6,4,
      //9,2,0,0,8,0,0,0,0,
      //0,0,0,7,6,3,0,0,0,
      //0,0,0,0,9,0,0,7,5,
      //6,3,0,0,0,0,0,0,8,
      //0,9,0,3,0,0,5,2,0,
      //0,0,2,4,0,0,6,0,0
    //)
    //assert(newSudoku.grid.deep == expectedGrid.deep)
  //}
}
