package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_INDEX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_SALARY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DASH_TAG;
import static seedu.address.logic.parser.ParserUtil.testByAllFields;

import seedu.address.logic.commands.ViewScheduleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonContainsFieldsPredicate;

/**
 * Class representing the view schedule command parser.
 */
public class ViewScheduleCommandParser implements Parser<ViewScheduleCommand> {

    private static final ParseException NO_FIELD_EXCEPTION =
            new ParseException(ViewScheduleCommand.MESSAGE_USAGE);

    @Override
    public ViewScheduleCommand parse(String args) throws ParseException {
        //currently defined for name prefix, undefined behaviour
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DASH_NAME, PREFIX_DASH_PHONE,
                        PREFIX_DASH_INDEX,
                        PREFIX_DASH_EMAIL, PREFIX_DASH_ADDRESS, PREFIX_DASH_TAG,
                        PREFIX_DASH_STATUS, PREFIX_DASH_ROLE, PREFIX_DASH_SALARY);
        if (argMultimap.isEmpty()) {
            throw new ParseException(ViewScheduleCommand.MESSAGE_USAGE);
        }
        PersonContainsFieldsPredicate predicate = testByAllFields(argMultimap);
        return new ViewScheduleCommand(predicate);
    }
}
