/* The following code was generated by JFlex 1.4.3 on 3/17/16 11:04 AM */

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.javascript2.lexer;

import org.netbeans.modules.javascript2.lexer.api.JsDocumentationTokenId;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/17/16 11:04 AM from the specification file
 * <tt>/home/petr/workspace/web-main/javascript2.lexer/tools/JsDocumentationColoringScanner.flex</tt>
 */
@org.netbeans.api.annotations.common.SuppressWarnings({"SF_SWITCH_FALLTHROUGH", "URF_UNREAD_FIELD", "DLS_DEAD_LOCAL_STORE", "DM_DEFAULT_ENCODING"})
public final class JsDocumentationColoringLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int AT = 6;
  public static final int STRING = 8;
  public static final int YYINITIAL = 0;
  public static final int STRINGEND = 10;
  public static final int DOCBLOCK_START = 4;
  public static final int DOCBLOCK = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5, 5
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\13\1\1\2\13\1\10\22\0\1\13\1\0\1\11\7\0"+
    "\1\14\1\0\1\16\2\0\1\3\12\7\2\0\1\2\1\0\1\6"+
    "\1\0\1\15\32\4\1\21\1\12\1\22\3\0\32\4\1\17\1\5"+
    "\1\20\42\0\1\13\11\0\1\4\12\0\1\4\4\0\1\4\5\0"+
    "\27\4\1\0\37\4\1\0\u01ca\4\4\0\14\4\16\0\5\4\7\0"+
    "\1\4\1\0\1\4\201\0\5\4\1\0\2\4\2\0\4\4\10\0"+
    "\1\4\1\0\3\4\1\0\1\4\1\0\24\4\1\0\123\4\1\0"+
    "\213\4\10\0\236\4\11\0\46\4\2\0\1\4\7\0\47\4\110\0"+
    "\33\4\5\0\3\4\55\0\53\4\25\0\12\7\4\0\2\4\1\0"+
    "\143\4\1\0\1\4\17\0\2\4\7\0\2\4\12\7\3\4\2\0"+
    "\1\4\20\0\1\4\1\0\36\4\35\0\131\4\13\0\1\4\16\0"+
    "\12\7\41\4\11\0\2\4\4\0\1\4\5\0\26\4\4\0\1\4"+
    "\11\0\1\4\3\0\1\4\27\0\31\4\107\0\1\4\1\0\13\4"+
    "\127\0\66\4\3\0\1\4\22\0\1\4\7\0\12\4\4\0\12\7"+
    "\1\0\7\4\1\0\7\4\5\0\10\4\2\0\2\4\2\0\26\4"+
    "\1\0\7\4\1\0\1\4\3\0\4\4\3\0\1\4\20\0\1\4"+
    "\15\0\2\4\1\0\3\4\4\0\12\7\2\4\23\0\6\4\4\0"+
    "\2\4\2\0\26\4\1\0\7\4\1\0\2\4\1\0\2\4\1\0"+
    "\2\4\37\0\4\4\1\0\1\4\7\0\12\7\2\0\3\4\20\0"+
    "\11\4\1\0\3\4\1\0\26\4\1\0\7\4\1\0\2\4\1\0"+
    "\5\4\3\0\1\4\22\0\1\4\17\0\2\4\4\0\12\7\25\0"+
    "\10\4\2\0\2\4\2\0\26\4\1\0\7\4\1\0\2\4\1\0"+
    "\5\4\3\0\1\4\36\0\2\4\1\0\3\4\4\0\12\7\1\0"+
    "\1\4\21\0\1\4\1\0\6\4\3\0\3\4\1\0\4\4\3\0"+
    "\2\4\1\0\1\4\1\0\2\4\3\0\2\4\3\0\3\4\3\0"+
    "\14\4\26\0\1\4\25\0\12\7\25\0\10\4\1\0\3\4\1\0"+
    "\27\4\1\0\12\4\1\0\5\4\3\0\1\4\32\0\2\4\6\0"+
    "\2\4\4\0\12\7\25\0\10\4\1\0\3\4\1\0\27\4\1\0"+
    "\12\4\1\0\5\4\3\0\1\4\40\0\1\4\1\0\2\4\4\0"+
    "\12\7\1\0\2\4\22\0\10\4\1\0\3\4\1\0\51\4\2\0"+
    "\1\4\20\0\1\4\21\0\2\4\4\0\12\7\12\0\6\4\5\0"+
    "\22\4\3\0\30\4\1\0\11\4\1\0\1\4\2\0\7\4\72\0"+
    "\60\4\1\0\2\4\14\0\7\4\11\0\12\7\47\0\2\4\1\0"+
    "\1\4\2\0\2\4\1\0\1\4\2\0\1\4\6\0\4\4\1\0"+
    "\7\4\1\0\3\4\1\0\1\4\1\0\1\4\2\0\2\4\1\0"+
    "\4\4\1\0\2\4\11\0\1\4\2\0\5\4\1\0\1\4\11\0"+
    "\12\7\2\0\4\4\40\0\1\4\37\0\12\7\26\0\10\4\1\0"+
    "\44\4\33\0\5\4\163\0\53\4\24\0\1\4\12\7\6\0\6\4"+
    "\4\0\4\4\3\0\1\4\3\0\2\4\7\0\3\4\4\0\15\4"+
    "\14\0\1\4\1\0\12\7\6\0\46\4\1\0\1\4\5\0\1\4"+
    "\2\0\53\4\1\0\u014d\4\1\0\4\4\2\0\7\4\1\0\1\4"+
    "\1\0\4\4\2\0\51\4\1\0\4\4\2\0\41\4\1\0\4\4"+
    "\2\0\7\4\1\0\1\4\1\0\4\4\2\0\17\4\1\0\71\4"+
    "\1\0\4\4\2\0\103\4\45\0\20\4\20\0\125\4\14\0\u026c\4"+
    "\2\0\21\4\1\0\32\4\5\0\113\4\25\0\15\4\1\0\4\4"+
    "\16\0\22\4\16\0\22\4\16\0\15\4\1\0\3\4\17\0\64\4"+
    "\43\0\1\4\4\0\1\4\3\0\12\7\46\0\12\7\6\0\130\4"+
    "\10\0\51\4\1\0\1\4\5\0\106\4\12\0\35\4\51\0\12\7"+
    "\36\4\2\0\5\4\13\0\54\4\25\0\7\4\10\0\12\7\46\0"+
    "\27\4\11\0\65\4\53\0\12\7\6\0\12\7\15\0\1\4\135\0"+
    "\57\4\21\0\7\4\4\0\12\7\51\0\36\4\15\0\2\4\12\7"+
    "\54\4\32\0\44\4\34\0\12\7\3\0\3\4\12\7\44\4\153\0"+
    "\4\4\1\0\4\4\3\0\2\4\11\0\300\4\100\0\u0116\4\2\0"+
    "\6\4\2\0\46\4\2\0\6\4\2\0\10\4\1\0\1\4\1\0"+
    "\1\4\1\0\1\4\1\0\37\4\2\0\65\4\1\0\7\4\1\0"+
    "\1\4\3\0\3\4\1\0\7\4\3\0\4\4\2\0\6\4\4\0"+
    "\15\4\5\0\3\4\1\0\7\4\164\0\1\4\15\0\1\4\20\0"+
    "\15\4\145\0\1\4\4\0\1\4\2\0\12\4\1\0\1\4\3\0"+
    "\5\4\6\0\1\4\1\0\1\4\1\0\1\4\1\0\4\4\1\0"+
    "\13\4\2\0\4\4\5\0\5\4\4\0\1\4\64\0\2\4\u0a7b\0"+
    "\57\4\1\0\57\4\1\0\205\4\6\0\4\4\3\0\2\4\14\0"+
    "\46\4\1\0\1\4\5\0\1\4\2\0\70\4\7\0\1\4\20\0"+
    "\27\4\11\0\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0"+
    "\7\4\1\0\7\4\1\0\7\4\1\0\7\4\120\0\1\4\u01d5\0"+
    "\2\4\52\0\5\4\5\0\2\4\4\0\126\4\6\0\3\4\1\0"+
    "\132\4\1\0\4\4\5\0\51\4\3\0\136\4\21\0\33\4\65\0"+
    "\20\4\u0200\0\u19b6\4\112\0\u51cd\4\63\0\u048d\4\103\0\56\4\2\0"+
    "\u010d\4\3\0\20\4\12\7\2\4\24\0\57\4\20\0\31\4\10\0"+
    "\106\4\61\0\11\4\2\0\147\4\2\0\4\4\1\0\4\4\14\0"+
    "\13\4\115\0\12\4\1\0\3\4\1\0\4\4\1\0\27\4\35\0"+
    "\64\4\16\0\62\4\34\0\12\7\30\0\6\4\3\0\1\4\4\0"+
    "\12\7\34\4\12\0\27\4\31\0\35\4\7\0\57\4\34\0\1\4"+
    "\12\7\46\0\51\4\27\0\3\4\1\0\10\4\4\0\12\7\6\0"+
    "\27\4\3\0\1\4\5\0\60\4\1\0\1\4\3\0\2\4\2\0"+
    "\5\4\2\0\1\4\1\0\1\4\30\0\3\4\2\0\13\4\7\0"+
    "\3\4\14\0\6\4\2\0\6\4\2\0\6\4\11\0\7\4\1\0"+
    "\7\4\221\0\43\4\15\0\12\7\6\0\u2ba4\4\14\0\27\4\4\0"+
    "\61\4\u2104\0\u016e\4\2\0\152\4\46\0\7\4\14\0\5\4\5\0"+
    "\1\4\1\0\12\4\1\0\15\4\1\0\5\4\1\0\1\4\1\0"+
    "\2\4\1\0\2\4\1\0\154\4\41\0\u016b\4\22\0\100\4\2\0"+
    "\66\4\50\0\14\4\164\0\5\4\1\0\207\4\23\0\12\7\7\0"+
    "\32\4\6\0\32\4\13\0\131\4\3\0\6\4\2\0\6\4\2\0"+
    "\6\4\2\0\3\4\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\3\1\1\0\1\2\1\3\1\2\1\4\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\2\17\1\1\2\20\1\21\1\0\1\22\1\23"+
    "\1\24\1\0\3\25\1\0\1\26\1\0\1\1\1\27";

  private static int [] zzUnpackAction() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\23\0\46\0\71\0\114\0\137\0\162\0\205"+
    "\0\230\0\253\0\162\0\276\0\321\0\162\0\344\0\230"+
    "\0\162\0\162\0\162\0\162\0\162\0\162\0\162\0\162"+
    "\0\162\0\367\0\u010a\0\162\0\u011d\0\162\0\u0130\0\162"+
    "\0\162\0\162\0\230\0\162\0\u0143\0\u0156\0\u0169\0\367"+
    "\0\u017c\0\u018f\0\162";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\3\7\1\10\10\7\1\11\6\7\1\12\1\13\1\14"+
    "\5\12\1\15\1\16\1\12\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\14\27\1\30\6\27\15\31"+
    "\1\32\5\31\1\33\1\34\6\33\1\35\1\36\1\37"+
    "\10\33\11\0\1\40\50\0\1\41\11\0\1\42\10\0"+
    "\1\43\6\0\1\12\2\44\5\12\1\45\1\44\1\12"+
    "\1\46\7\44\3\0\2\47\17\0\1\13\34\0\1\17"+
    "\13\0\1\50\2\0\1\50\13\0\1\33\1\0\6\33"+
    "\2\0\1\51\10\33\1\0\1\34\21\0\1\7\1\33"+
    "\6\7\1\52\12\7\1\0\1\44\34\0\1\46\7\0"+
    "\1\47\2\0\2\47\1\0\1\53\1\47\1\0\3\47"+
    "\1\0\6\47\1\0\1\33\6\0\1\52\12\0\10\33"+
    "\2\0\1\51\10\33";

  private static int [] zzUnpackTrans() {
    int [] result = new int[418];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\6\0\1\11\2\1\1\0\1\11\2\1\1\11\2\1"+
    "\11\11\2\1\1\11\1\1\1\11\1\0\3\11\1\0"+
    "\1\11\2\1\1\0\1\1\1\0\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private LexerInput input;

    public JsDocumentationColoringLexer(LexerRestartInfo info) {
        this.input = info.input();

        if(info.state() != null) {
            //reset state
            setState((LexerState)info.state());
        } else {
            //initial state
            zzState = zzLexicalState = YYINITIAL;
        }
    }

    public LexerState getState() {
        if (zzState == YYINITIAL && zzLexicalState == YYINITIAL) {
            return null;
        }
        return new LexerState(zzState, zzLexicalState);
    }

    public void setState(LexerState state) {
        this.zzState = state.zzState;
        this.zzLexicalState = state.zzLexicalState;
    }

    public JsDocumentationTokenId nextToken() throws java.io.IOException {
        JsDocumentationTokenId token = yylex();
        return token;
    }

    public static final class LexerState  {
        /** the current state of the DFA */
        final int zzState;
        /** the current lexical state */
        final int zzLexicalState;

        LexerState (int zzState, int zzLexicalState) {
            this.zzState = zzState;
            this.zzLexicalState = zzLexicalState;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final LexerState other = (LexerState) obj;
            if (this.zzState != other.zzState) {
                return false;
            }
            if (this.zzLexicalState != other.zzLexicalState) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + this.zzState;
            hash = 29 * hash + this.zzLexicalState;
            return hash;
        }

        @Override
        public String toString() {
            return "LexerState{" + "zzState=" + zzState + ", zzLexicalState=" + zzLexicalState + '}';
        }
    }

 // End user code



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public JsDocumentationColoringLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public JsDocumentationColoringLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1648) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return input.readText().toString();
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return input.readText().charAt(pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return input.readLength();
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    input.backup(number);
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  @SuppressWarnings("fallthrough")
  public JsDocumentationTokenId yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzMarkedPosL;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      int tokenLength = 0;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
            zzInput = input.read();
            if(zzInput == LexerInput.EOF) {
            zzInput = YYEOF;
            break zzForAction;
          }

          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            tokenLength = input.readLength();
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      if(zzInput != YYEOF) {
          input.backup(input.readLength() - tokenLength);
      }

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 6: 
          { return JsDocumentationTokenId.ASTERISK;
          }
        case 24: break;
        case 9: 
          { return JsDocumentationTokenId.BRACKET_LEFT_CURLY;
          }
        case 25: break;
        case 14: 
          { yybegin(DOCBLOCK); return JsDocumentationTokenId.COMMENT_DOC_START;
          }
        case 26: break;
        case 12: 
          { return JsDocumentationTokenId.BRACKET_RIGHT_BRACKET;
          }
        case 27: break;
        case 11: 
          { return JsDocumentationTokenId.BRACKET_LEFT_BRACKET;
          }
        case 28: break;
        case 7: 
          { yybegin(AT); yypushback(1);
          }
        case 29: break;
        case 20: 
          { return JsDocumentationTokenId.COMMENT_END;
          }
        case 30: break;
        case 18: 
          { yybegin(DOCBLOCK); return JsDocumentationTokenId.STRING_END;
          }
        case 31: break;
        case 10: 
          { return JsDocumentationTokenId.BRACKET_RIGHT_CURLY;
          }
        case 32: break;
        case 21: 
          { yypushback(1); return JsDocumentationTokenId.OTHER;
          }
        case 33: break;
        case 5: 
          { return JsDocumentationTokenId.WHITESPACE;
          }
        case 34: break;
        case 19: 
          { yybegin(DOCBLOCK_START);
          }
        case 35: break;
        case 13: 
          { yypushback(1); yybegin(DOCBLOCK); return JsDocumentationTokenId.COMMENT_BLOCK_START;
          }
        case 36: break;
        case 16: 
          { yypushback(1); yybegin(DOCBLOCK);
                                        if (tokenLength - 1 > 0) {
                                            return JsDocumentationTokenId.UNKNOWN;
                                        }
          }
        case 37: break;
        case 8: 
          { return JsDocumentationTokenId.COMMA;
          }
        case 38: break;
        case 4: 
          { yybegin(STRING); return JsDocumentationTokenId.STRING_BEGIN;
          }
        case 39: break;
        case 3: 
          { return JsDocumentationTokenId.OTHER;
          }
        case 40: break;
        case 2: 
          { return JsDocumentationTokenId.EOL;
          }
        case 41: break;
        case 17: 
          { yypushback(1); yybegin(STRINGEND);
                                        if (tokenLength - 1 > 0) {
                                            return JsDocumentationTokenId.STRING;
                                        }
          }
        case 42: break;
        case 22: 
          { yybegin(DOCBLOCK); return JsDocumentationTokenId.KEYWORD;
          }
        case 43: break;
        case 15: 
          { yybegin(DOCBLOCK); return JsDocumentationTokenId.AT;
          }
        case 44: break;
        case 23: 
          { return JsDocumentationTokenId.HTML;
          }
        case 45: break;
        case 1: 
          { 
          }
        case 46: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {
                if (input.readLength() > 0) {
        // backup eof
        input.backup(1);
        //and return the text as error token
        return JsDocumentationTokenId.UNKNOWN;
    } else {
        return null;
    }
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
