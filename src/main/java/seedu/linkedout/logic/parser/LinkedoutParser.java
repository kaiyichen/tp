package seedu.linkedout.logic.parser;

import static seedu.linkedout.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.linkedout.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.linkedout.logic.commands.AddCommand;
import seedu.linkedout.logic.commands.AddSkillCommand;
import seedu.linkedout.logic.commands.ClearCommand;
import seedu.linkedout.logic.commands.Command;
import seedu.linkedout.logic.commands.DeleteCommand;
import seedu.linkedout.logic.commands.EditCommand;
import seedu.linkedout.logic.commands.ExitCommand;
import seedu.linkedout.logic.commands.FlagCommand;
import seedu.linkedout.logic.commands.HelpCommand;
import seedu.linkedout.logic.commands.ListCommand;
import seedu.linkedout.logic.commands.SearchCommand;
import seedu.linkedout.logic.commands.SortCommand;
import seedu.linkedout.logic.commands.ViewCommand;
import seedu.linkedout.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class LinkedoutParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case AddSkillCommand.COMMAND_WORD:
            return new AddSkillCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case ViewCommand.COMMAND_WORD:
            return new ViewCommandParser().parse(arguments);

        case SearchCommand.COMMAND_WORD:
            return new SearchCommandParser().parse(arguments);

        case FlagCommand.COMMAND_WORD:
            return new FlagCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case SortCommand.COMMAND_WORD:
            return new SortCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
