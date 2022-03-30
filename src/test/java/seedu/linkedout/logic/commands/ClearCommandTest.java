package seedu.linkedout.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.linkedout.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.linkedout.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;
import static seedu.linkedout.testutil.TypicalApplicants.getTypicalLinkedout;

import org.junit.jupiter.api.Test;

import seedu.linkedout.logic.commands.exceptions.CommandException;
import seedu.linkedout.logic.parser.exceptions.ParseException;
import seedu.linkedout.model.Linkedout;
import seedu.linkedout.model.Model;
import seedu.linkedout.model.ModelManager;
import seedu.linkedout.model.UserPrefs;
import seedu.linkedout.ui.ClearAlertBox;

public class ClearCommandTest {

//    @Test
//    public void execute_emptyLinkedout_success() {
//        Model model = new ModelManager();
//        Model expectedModel = new ModelManager();
//
//        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
//    }

//    @Test
//    public void execute_nonEmptyLinkedout_success() {
//        Model model = new ModelManager(getTypicalLinkedout(), new UserPrefs());
//        ClearCommand clearCommand = new ClearCommand();
//
////expected one
//        ClearAlertBox clearAlertBox = new ClearAlertBox();
//        clearAlertBox.showInformationAlert(ClearCommand.MESSAGE_SUCCESS);
//    }

//    @Test
//    public void execute_nonEmptyLinkedout_success() {
//        Model model = new ModelManager(getTypicalLinkedout(), new UserPrefs());
//        Model expectedModel = new ModelManager(getTypicalLinkedout(), new UserPrefs());
//        expectedModel.setLinkedout(new Linkedout()); // when user picks yes
//
//        //i need to write when user pick yes
//
//        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
//    }

    @Test
    public void execute_Linkedout_success() {
        ClearAlertBox clearAlertBox = new ClearAlertBox();
        clearAlertBox.showConfirmationAlert(ClearCommand.MESSAGE_CONFIRMTION);

        Model model = new ModelManager(getTypicalLinkedout(), new UserPrefs());
        ClearCommand clearCommand = new ClearCommand();
        clearCommand.execute(model);
        assertEquals(clearCommand, clearAlertBox);

    }
}
//    @Test
//    public void execute_help_success() {
//        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false);
//        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
//    }
//    private void assertCommandSuccess(String inputCommand, String expectedMessage,
//                                      Model expectedModel) throws CommandException, ParseException {
//        CommandResult result = logic.execute(inputCommand);
//        assertEquals(expectedMessage, result.getFeedbackToUser());
//        assertEquals(expectedModel, model);
////    }
//}
