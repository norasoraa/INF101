package no.uib.inf101.tetris.model.tetromino;

/** Interface that contains methods for a factory to produce tetrominos. */
public interface TetrominoFactory {

  /**
   * Gets a new Tetromino from the collection of Tetromino-families. Chooses a
   * symbol for the next tetromino from the collection.
   * 
   * @return a new Tetromino with the symbol choosen
   */
  Tetromino getNext();
}
