package main;

import java.awt.print.Paper;
import java.util.HashSet;

public abstract class AbstractPaperBuilder {

        protected HashSet<Paper> papers;

        public AbstractPaperBuilder() {
            papers = new HashSet<>();
        }

        public AbstractPaperBuilder(HashSet<Paper> papers) {
            this.papers = papers;
        }

        public HashSet<Paper> getPapers() {
            return (HashSet<Paper>) papers.clone();
        }
        public abstract void buildSetPapers(String filename) throws PapersException;
    }

