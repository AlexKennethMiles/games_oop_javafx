package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void correctPosition() {
        Figure figure = new BishopBlack(Cell.C1);
        assertThat(figure.position(), is(Cell.C1));
    }

    @Test
    public void correctCopy() {
        Figure figure = new BishopBlack(Cell.C1);
        figure = figure.copy(Cell.C2);
        assertThat(figure.position(), is(Cell.C2));
    }

    @Test
    public void wayUpAndRight() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] way = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(figure.way(Cell.G5), is(way));
    }

    @Test
    public void wayUpAndLeft() {
        Figure figure = new BishopBlack(Cell.E1);
        Cell[] way = {Cell.D2, Cell.C3, Cell.B4, Cell.A5};
        assertThat(figure.way(Cell.A5), is(way));
    }

    @Test
    public void wayDownAndRight() {
        Figure figure = new BishopBlack(Cell.A8);
        Cell[] way = {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(figure.way(Cell.H1), is(way));
    }

    @Test
    public void wayDownAndLeft() {
        Figure figure = new BishopBlack(Cell.G5);
        Cell[] way = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(figure.way(Cell.C1), is(way));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void incorrectDiagonalWay() {
        Figure figure = new BishopBlack(Cell.A1);
        figure.way(Cell.C1);
    }
}