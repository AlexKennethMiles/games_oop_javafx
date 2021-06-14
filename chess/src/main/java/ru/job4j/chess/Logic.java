package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
    }

    protected boolean free(Cell[] steps) throws OccupiedCellException {
        for (Cell step : steps) {
            for (Figure figure : figures) {
                if (figure.position() == step) {
                    throw new OccupiedCellException();
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }

    public void prepareTheBoard() {
        // white
        add(new PawnWhite(Cell.A2));
        add(new PawnWhite(Cell.B2));
        add(new PawnWhite(Cell.C2));
        add(new PawnWhite(Cell.D2));
        add(new PawnWhite(Cell.E2));
        add(new PawnWhite(Cell.F2));
        add(new PawnWhite(Cell.G2));
        add(new PawnWhite(Cell.H2));
        add(new RookWhite(Cell.A1));
        add(new KnightWhite(Cell.B1));
        add(new BishopWhite(Cell.C1));
        add(new QueenWhite(Cell.D1));
        add(new KingWhite(Cell.E1));
        add(new BishopWhite(Cell.F1));
        add(new KnightWhite(Cell.G1));
        add(new RookWhite(Cell.H1));
        // black
        add(new PawnBlack(Cell.A7));
        add(new PawnBlack(Cell.B7));
        add(new PawnBlack(Cell.C7));
        add(new PawnBlack(Cell.D7));
        add(new PawnBlack(Cell.E7));
        add(new PawnBlack(Cell.F7));
        add(new PawnBlack(Cell.G7));
        add(new PawnBlack(Cell.H7));
        add(new RookBlack(Cell.A8));
        add(new KnightBlack(Cell.B8));
        add(new BishopBlack(Cell.C8));
        add(new QueenBlack(Cell.D8));
        add(new KingBlack(Cell.E8));
        add(new BishopBlack(Cell.F8));
        add(new KnightBlack(Cell.G8));
        add(new RookBlack(Cell.H8));
    }
}
