import java.util.Optional;

/**
 * represents methods that change state
 */
public interface StateChangingMethod {
    Optional<PlayList> undo();
    Playable redo();
    StateChangingMethod clone();
}
