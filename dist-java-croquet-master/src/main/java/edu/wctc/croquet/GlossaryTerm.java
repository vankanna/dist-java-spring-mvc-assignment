package edu.wctc.croquet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GlossaryTerm {
    private String term;
    private String definition;
    private String regulation;
}