package io.github.tahanima.data;

import com.univocity.parsers.annotations.Parsed;

import lombok.Getter;
import lombok.ToString;

/**
 * @author tahanima
 */
@Getter
@ToString(callSuper = true)
public class CategoryTestData extends BaseTestData {
    @Parsed(field = "Category", defaultNullRead = "")
    private String category;

    @Parsed(field = "Row", defaultNullRead = "")
    private String row;
}
