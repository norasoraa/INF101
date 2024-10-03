package no.uib.inf101.datastructure;

// Les om records her: https://inf101.ii.uib.no/notat/mutabilitet/#record

/**
 * A GridCell contains a CellPosition and an element.
 *
 * @param cellPosition  the position of the cell
 * @param elem        the element of the cell
 */
public record GridCell<T>(CellPosition pos, T elem) { }
