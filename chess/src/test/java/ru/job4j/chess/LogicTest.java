package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test(expected = ImpossibleMoveException.class)
    public void moveImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.prepareTheBoard();
        logic.move(Cell.C8, Cell.A1);
    }

    @Test(expected = OccupiedCellException.class)
    public void free() throws OccupiedCellException {
        Logic logic = new Logic();
        logic.prepareTheBoard();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.free(bishopBlack.way(Cell.G5));
    }

    @Test(expected = OccupiedCellException.class)
    public void moveOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.prepareTheBoard();
        logic.move(Cell.C8, Cell.D7);
    }

    @Test(expected = FigureNotFoundException.class)
    public void moveFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.prepareTheBoard();
        logic.move(Cell.C6, Cell.C5);
    }
}