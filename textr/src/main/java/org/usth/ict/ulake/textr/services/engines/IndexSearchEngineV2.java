package org.usth.ict.ulake.textr.services.engines;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.tika.exception.TikaException;
import org.usth.ict.ulake.textr.models.payloads.responses.IndexResponse;
import org.usth.ict.ulake.textr.models.payloads.responses.SearchResponse;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public interface IndexSearchEngineV2 {
    
    Logger log = Logger.getLogger(IndexSearchEngineV2.class.getName());

    Document getDocument(Long id, String filename, File file) throws IOException, TikaException;

    Document getDocument(Long id, String filename, String contents);

    IndexResponse indexDoc(Document doc) throws IOException;

    void deleteDoc(Long id) throws IOException;

    SearchResponse searchDoc(String query) throws IOException, InvalidTokenOffsetsException;

    void commit() throws IOException;
}
