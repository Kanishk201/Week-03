package doublylinkedlist.undoredofunctionality;

class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
    }
}
