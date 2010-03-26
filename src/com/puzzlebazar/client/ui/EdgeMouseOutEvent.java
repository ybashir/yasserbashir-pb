package com.puzzlebazar.client.ui;

import com.puzzlebazar.shared.util.Recti;
import com.puzzlebazar.shared.util.Vec2i;

/**
 * Represents a mouse out event within an edge of a square grid.
 * See {@link SquareGridManipulator} for details.
 */
public class EdgeMouseOutEvent extends EdgeEvent<EdgeMouseOutHandler> {

  /**
   * Event type for edge mouse out events. Represents the meta-data associated with
   * this event.
   */
  private static final Type<EdgeMouseOutHandler> TYPE = new Type<EdgeMouseOutHandler>();

  /**
   * Gets the event type associated with edge mouse out events.
   * 
   * @return the handler type
   */
  public static Type<EdgeMouseOutHandler> getType() {
    return TYPE;
  }

  /**
   * Creates a {@link EdgeMouseOutEvent} at the specified cell coordinate.
   * See {@link Recti} for the difference between cell and vertex coordinates.
   * 
   * @param vertical {@code true} if the edge is vertical, {@code false} if it is horizontal.
   * @param edge The edge coordinates. 
   *     For vertical edges, x must be a vertex coordinate and y must be a cell coordinate.
   *     For horizontal edges, x must be a cell coordinate and y must be a vertex coordinate.
   */
  public EdgeMouseOutEvent( boolean vertical, Vec2i edge ) {
    super( vertical, edge );
  }

  @Override
  public final Type<EdgeMouseOutHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EdgeMouseOutHandler handler) {
    handler.onEdgeMouseOut(this);
  }


}