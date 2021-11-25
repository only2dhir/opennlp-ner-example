package com.devglan;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by only2dhir on 15-07-2017.
 */
public class NameFinder {

    public void findName(String paragraph) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
        NameFinderME nameFinder = new NameFinderME(model);
        String[] tokens = tokenize(paragraph);

        Span nameSpans[] = nameFinder.find(tokens);
        for(Span s: nameSpans)
            System.out.println(tokens[s.getStart()]);
    }

    public String[] tokenize(String sentence) throws IOException{
        InputStream inputStreamTokenizer = getClass().getResourceAsStream("/en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
        TokenizerME tokenizer = new TokenizerME(tokenModel);
        return tokenizer.tokenize(sentence);
    }


}
