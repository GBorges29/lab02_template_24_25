package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {

        throw new UnsupportedOperationException("Null values are not allowed.");
    }

  public NullNotAllowedException(String message) {
    throw new UnsupportedOperationException(message);
  }
}
