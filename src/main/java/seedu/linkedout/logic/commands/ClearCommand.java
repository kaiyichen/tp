package seedu.linkedout.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import seedu.linkedout.model.Linkedout;
import seedu.linkedout.model.Model;

/**
 * Clears the linkedout app.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "LinkedOUT has been cleared!";
    public static final String MESSAGE_FAIL = "LinkedOUT is not cleared";
    public static final String MESSAGE_CONFIRMTION = "Are you sure you want to clear the list?";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        //handleClear();
        if (isConfirmClear()) {
            showInformationAlert(ClearCommand.MESSAGE_SUCCESS);
            model.setLinkedout(new Linkedout());
            return new CommandResult(MESSAGE_SUCCESS);
        } else {
            return new CommandResult(MESSAGE_FAIL);
        }
    }

    private boolean isConfirmClear() {
        return showConfirmationAlert(MESSAGE_CONFIRMTION);
    }

    private void showInformationAlert(String response) {
        final Alert alert = new Alert(Alert.AlertType.INFORMATION, response);
        alert.showAndWait();
    }

    private boolean showConfirmationAlert(String content) {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION, content, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        return alert.getResult() == ButtonType.YES;
    }
}
