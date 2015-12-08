class AutogradeCheck {
    @SuppressWarnings("unused")
    public void checkStuffExists() {
        Exception e1 = new UnknownCandidateException("gompei");
        Exception e2 = new CandidateExistsException("gompei");
        Exception e3 = new DuplicateVotesException("gompei");
        ElectionData ED = new ElectionData();
        try {
            ED.addCandidate("a");
        } catch (CandidateExistsException e) {
        }
        try {
            ED.processVote("a", "b", "c");
        } catch (UnknownCandidateException e) {
        } catch (DuplicateVotesException e) {
        }
        String winner1 = ED.findWinnerMostFirstVotes();
        String winner2 = ED.findWinnerMostPoints();
    }
}
