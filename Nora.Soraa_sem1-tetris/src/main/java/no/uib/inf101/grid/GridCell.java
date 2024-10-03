package no.uib.inf101.grid;

/** A record representing a GridCell, which contains the position and the value of the cell */
public record GridCell<E>(CellPosition pos, E value) { }
