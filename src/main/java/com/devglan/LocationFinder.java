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
public class LocationFinder {

    public void findLocation(String paragraph) throws IOException {
        InputStream inputStreamNameFinder = getClass().getResourceAsStream("/en-ner-location.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);

        NameFinderME locFinder = new NameFinderME(model);
        String[] tokens = tokenize(paragraph);

        Span nameSpans[] = locFinder.find(tokens);
        for(Span span : nameSpans)

            System.out.println("Position - "+ span.toString() + "    LocationName - " + tokens[span.getStart()]);
    }
    public String[] tokenize(String sentence) throws IOException{
        InputStream inputStreamTokenizer = getClass().getResourceAsStream("/en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

        TokenizerME tokenizer = new TokenizerME(tokenModel);
        return tokenizer.tokenize(sentence);
    }


}
