package seedu.linkedout.model.applicant;

import static java.util.Objects.requireNonNull;
import static seedu.linkedout.commons.util.AppUtil.checkArgument;

/**
 * Represents a Applicant's stage in the linkedout app.
 * Guarantees: immutable; is valid as declared in {@link #isValidStage(String)}
 */
public class Stage {

    public static final String MESSAGE_CONSTRAINTS = "Stages can take any values, and it should not be blank";

    /*
     * The first character of the stage must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs a {@code Stage}.
     *
     * @param stage A valid stage.
     */
    public Stage(String stage) {
        requireNonNull(stage);
        checkArgument(isValidStage(stage), MESSAGE_CONSTRAINTS);
        value = stage;
    }

    /**
     * Returns true if a given string is a valid stage.
     */
    public static boolean isValidStage(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Stage // instanceof handles nulls
                && value.equals(((Stage) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
