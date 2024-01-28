/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package texteditor.service;

import texteditor.models.CharacterNode;

/** Simple text editor */
public interface ITextEditor {
    void moveLeft();

    void moveRight();

    void backspace();

    void insert(char data);

    void undo();

    String print();

    CharacterNode getCursor();
}