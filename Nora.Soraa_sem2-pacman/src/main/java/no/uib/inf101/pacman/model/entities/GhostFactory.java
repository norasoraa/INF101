package no.uib.inf101.pacman.model.entities;

import no.uib.inf101.pacman.model.EntityModel;

/** Interface that contains methods for a factory to produce ghosts. */
public interface GhostFactory {

  /**
   * Gets a new Ghost. The ghost is placed on a random position and has a random
   * direction.
   * 
   * @param model the model as an {@link EntityModel}
   * @return a new ghost at a random position and with a random direction
   */
  Ghost getNext(EntityModel model);
}
