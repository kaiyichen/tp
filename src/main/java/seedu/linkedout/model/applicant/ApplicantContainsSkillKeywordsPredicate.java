package seedu.linkedout.model.applicant;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Tests that a {@code Applicant}'s {@code Skills} contains any of the keywords given.
 */
public class ApplicantContainsSkillKeywordsPredicate extends KeywordsPredicate implements Predicate<Applicant> {

    private final List<String> keywords;
    /**
     * @param keywords
     */
    public ApplicantContainsSkillKeywordsPredicate(List<String> keywords) {
        super(keywords);
        this.keywords = keywords;
    }

    @Override
    public boolean test(Applicant applicant) {
        int numberMatches = numberOfKeywordMatches(applicant);
        boolean allMatch = false;

        Set<String> currentApplicantSkills = applicant.getSkills()
                .stream().map(skill -> skill.skillName.toLowerCase()).collect(Collectors.toSet());

        for (int i = 0; i < keywords.size(); i++) {
            if (currentApplicantSkills.contains(keywords.get(i).toLowerCase())) {
                allMatch = true;
            }
        }

        return allMatch;
    }


    @Override
    public int numberOfKeywordMatches(Applicant applicant) {
        int numberMatches = 0;

        Set<String> currentApplicantSkills = applicant.getSkills()
                .stream().map(skill -> skill.skillName.toLowerCase()).collect(Collectors.toSet());

        for (int i = 0; i < keywords.size(); i++) {
            if (currentApplicantSkills.contains(keywords.get(i).toLowerCase())) {
                numberMatches++;
            }
        }

        return numberMatches;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ApplicantContainsSkillKeywordsPredicate // instanceof handles nulls
                && keywords.toString().equalsIgnoreCase(((
                ApplicantContainsSkillKeywordsPredicate) other).keywords.toString())); // state check
    }

}