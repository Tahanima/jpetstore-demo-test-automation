package io.github.tahanima.data;

import com.univocity.parsers.annotations.Parsed;

import lombok.Getter;
import lombok.ToString;

/**
 * @author tahanima
 */
@Getter
@ToString
public class BaseTestData {
    @Parsed(field = "Test Case ID", defaultNullRead = "")
    private String testCaseId;

    @Parsed(field = "Test Case Description", defaultNullRead = "")
    private String testCaseDescription;

    @Parsed(field = "Expected Outcome", defaultNullRead = "")
    private String expectedOutcome;
}
