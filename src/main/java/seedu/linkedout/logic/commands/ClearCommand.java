package seedu.linkedout.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.linkedout.model.Linkedout;
import seedu.linkedout.model.Model;

/**
 * Clears the linkedout app.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "LinkedOUT has been cleared!";
    public static final String MESSAGE_CONFIRMTION = "Are you sure you want to clear the list?";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(MESSAGE_CONFIRMTION, false, false, true);
    }
}
