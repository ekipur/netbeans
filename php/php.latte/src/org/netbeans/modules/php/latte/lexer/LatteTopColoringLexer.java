/* The following code was generated by JFlex 1.4.3 on 1.6.16 7:36 */

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

package org.netbeans.modules.php.latte.lexer;

import java.util.ArrayDeque;
import java.util.Objects;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.modules.web.common.api.ByteStack;


/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 1.6.16 7:36 from the specification file
 * <tt>/home/gapon/worx/sun/nb-main/php.latte/tools/LatteTopColoringLexer.flex</tt>
 */
@org.netbeans.api.annotations.common.SuppressWarnings({"SF_SWITCH_FALLTHROUGH", "URF_UNREAD_FIELD", "DLS_DEAD_LOCAL_STORE", "DM_DEFAULT_ENCODING"})
public class LatteTopColoringLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = LexerInput.EOF;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int ST_N_ATTR_DOUBLE = 22;
  public static final int ST_DOUBLE = 8;
  public static final int ST_SYNTAX_CHANGE = 16;
  public static final int ST_POSSIBLE_LATTE = 4;
  public static final int ST_ASP = 10;
  public static final int ST_N_ATTR_SINGLE = 24;
  public static final int ST_LATTE = 6;
  public static final int ST_COMMENT = 2;
  public static final int ST_PYTHON_DOUBLE = 14;
  public static final int ST_HIGHLIGHTING_ERROR = 26;
  public static final int ST_IN_HTML_TAG = 18;
  public static final int YYINITIAL = 0;
  public static final int ST_IN_SYNTAX_ATTR = 20;
  public static final int ST_PYTHON = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7,
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12, 13, 13
  };

  /**
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED =
    "\11\0\1\12\1\22\2\0\1\1\22\0\1\12\1\21\1\27\1\0"+
    "\1\23\1\3\1\0\1\30\2\0\1\2\2\0\1\25\1\0\1\13"+
    "\12\24\1\20\1\0\1\16\1\26\1\17\1\23\1\0\1\10\1\36"+
    "\1\24\1\33\1\32\1\41\1\24\1\40\3\24\1\31\1\24\1\6"+
    "\1\34\1\37\2\24\1\4\1\7\1\35\2\24\1\11\1\5\1\24"+
    "\1\0\1\42\2\0\1\23\1\0\1\10\1\36\1\24\1\33\1\32"+
    "\1\41\1\24\1\40\3\24\1\31\1\24\1\6\1\34\1\37\2\24"+
    "\1\4\1\7\1\35\2\24\1\11\1\5\1\24\1\14\1\0\1\15"+
    "\uff82\0";

  /**
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\14\0\2\2\1\3\1\2\1\1\2\2"+
    "\2\4\1\5\2\6\1\2\1\6\1\7\1\10\1\2"+
    "\2\10\1\11\1\10\1\2\1\11\3\10\1\2\1\11"+
    "\2\10\1\0\3\2\7\5\1\2\2\5\1\2\1\5"+
    "\1\12\1\13\3\0\1\14\3\0\1\15\1\5\1\16"+
    "\1\17\1\20\2\6\1\0\2\10\1\0\2\10\1\0"+
    "\2\10\1\0\1\21\7\0\1\22\1\0\1\22\2\0"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\2\6\6\10\2\0\1\34\2\0\1\35"+
    "\1\0\2\6\6\10\1\0\1\36\3\0\2\6\6\10"+
    "\1\37\1\40\1\41\2\0\2\6\6\10\1\42\1\43"+
    "\1\6\1\44\1\10\1\44\1\10\1\44\1\10\1\44"+
    "\5\6\17\10\5\6\17\10\1\45\2\6\1\46\1\6"+
    "\1\45\2\10\1\46\1\10\1\45\2\10\1\46\1\10"+
    "\1\45\2\10\1\46\1\10\1\45\2\6\1\46\1\6"+
    "\1\45\2\10\1\46\1\10\1\45\2\10\1\46\1\10"+
    "\1\45\2\10\1\46\1\10\1\47\2\6\1\47\2\10"+
    "\1\47\2\10\1\47\2\10\1\47\1\50\1\51\1\47"+
    "\1\50\1\51\1\47\1\50\1\51\1\47\1\50\1\51"+
    "\1\50\1\51\1\50\1\51\1\50\1\51\1\50\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[280];
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
    "\0\0\0\43\0\106\0\151\0\214\0\257\0\322\0\365"+
    "\0\u0118\0\u013b\0\u015e\0\u0181\0\u01a4\0\u01c7\0\u01ea\0\u0118"+
    "\0\u020d\0\u0230\0\u0253\0\u0276\0\u0299\0\u01ea\0\u02bc\0\u02df"+
    "\0\u0302\0\u0325\0\u0348\0\u036b\0\u01ea\0\u038e\0\u03b1\0\u03d4"+
    "\0\u03f7\0\u041a\0\u043d\0\u0460\0\u0483\0\u04a6\0\u04c9\0\u04ec"+
    "\0\u050f\0\u0532\0\u0555\0\u0578\0\u041a\0\u059b\0\u05be\0\u05e1"+
    "\0\u01ea\0\u0604\0\u0627\0\u064a\0\u066d\0\u0690\0\u06b3\0\u06d6"+
    "\0\u06f9\0\u071c\0\u073f\0\u0762\0\u01ea\0\u01ea\0\u0785\0\u07a8"+
    "\0\u07cb\0\u07ee\0\u07ee\0\u0811\0\u0834\0\u0857\0\u087a\0\u01ea"+
    "\0\u01ea\0\u01ea\0\u089d\0\u08c0\0\u08e3\0\u0906\0\u0929\0\u094c"+
    "\0\u096f\0\u0992\0\u09b5\0\u09d8\0\u09fb\0\u0a1e\0\u01ea\0\u0a41"+
    "\0\u0a64\0\u0a87\0\u0aaa\0\u0acd\0\u0af0\0\u06b3\0\u01ea\0\u06f9"+
    "\0\u06b3\0\u071c\0\u0762\0\u071c\0\u01ea\0\u01ea\0\u01ea\0\u01ea"+
    "\0\u01ea\0\u01ea\0\u01ea\0\u01ea\0\u01ea\0\u0b13\0\u0b36\0\u0b59"+
    "\0\u0b7c\0\u0b9f\0\u0bc2\0\u0be5\0\u0c08\0\u0c2b\0\u0c4e\0\u01ea"+
    "\0\u0c71\0\u0c94\0\u01ea\0\u0cb7\0\u0cda\0\u0cfd\0\u0d20\0\u0d43"+
    "\0\u0d66\0\u0d89\0\u0dac\0\u0dcf\0\u0df2\0\u01ea\0\u0e15\0\u0e38"+
    "\0\u0e5b\0\u0e7e\0\u0ea1\0\u0ec4\0\u0ee7\0\u0f0a\0\u0f2d\0\u0f50"+
    "\0\u0f73\0\u01ea\0\u01ea\0\u01ea\0\u0f96\0\u0fb9\0\u0fdc\0\u0fff"+
    "\0\u1022\0\u1045\0\u1068\0\u108b\0\u10ae\0\u10d1\0\u01ea\0\u01ea"+
    "\0\u10f4\0\u0302\0\u1117\0\u038e\0\u113a\0\u043d\0\u115d\0\u04ec"+
    "\0\u1180\0\u11a3\0\u11c6\0\u11e9\0\u120c\0\u122f\0\u1252\0\u1275"+
    "\0\u1298\0\u12bb\0\u12de\0\u1301\0\u1324\0\u1347\0\u136a\0\u138d"+
    "\0\u13b0\0\u13d3\0\u13f6\0\u1419\0\u143c\0\u145f\0\u1482\0\u14a5"+
    "\0\u14c8\0\u14eb\0\u150e\0\u1531\0\u1554\0\u1577\0\u159a\0\u15bd"+
    "\0\u15e0\0\u1603\0\u1626\0\u1649\0\u166c\0\u168f\0\u16b2\0\u16d5"+
    "\0\u16f8\0\u171b\0\u173e\0\u1761\0\u1784\0\u17a7\0\u17ca\0\u17ed"+
    "\0\u1810\0\u1833\0\u1856\0\u1879\0\u189c\0\u18bf\0\u18e2\0\u1905"+
    "\0\u1928\0\u194b\0\u196e\0\u1991\0\u01ea\0\u19b4\0\u19d7\0\u01ea"+
    "\0\u19fa\0\u08e3\0\u1a1d\0\u1a40\0\u08e3\0\u1a63\0\u043d\0\u1a86"+
    "\0\u1aa9\0\u043d\0\u1acc\0\u04ec\0\u1aef\0\u1b12\0\u04ec\0\u1b35"+
    "\0\u1b58\0\u1b7b\0\u1b9e\0\u1bc1\0\u1be4\0\u1c07\0\u1c2a\0\u1c4d"+
    "\0\u1c70\0\u1c93\0\u1cb6\0\u1cd9\0\u01ea\0\u1cfc\0\u1d1f\0\u08e3"+
    "\0\u1d42\0\u1d65\0\u043d\0\u1d88\0\u1dab\0\u04ec\0\u1dce\0\u1df1"+
    "\0\u01ea\0\u01ea\0\u08e3\0\u08e3\0\u043d\0\u043d\0\u04ec\0\u04ec";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[280];
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
    "\1\17\1\20\10\17\1\20\1\17\1\21\1\17\1\22"+
    "\3\17\1\20\20\17\1\23\1\24\1\25\7\23\1\24"+
    "\7\23\1\24\20\23\1\26\1\27\10\26\1\27\1\26"+
    "\1\30\5\26\1\27\20\26\1\31\1\20\2\31\1\32"+
    "\5\31\1\33\1\34\1\31\1\35\4\31\1\20\20\31"+
    "\1\36\1\37\2\36\1\40\5\36\1\37\1\41\1\36"+
    "\1\42\4\36\1\37\20\36\1\43\1\44\1\43\1\45"+
    "\1\46\5\43\1\44\1\47\6\43\1\44\20\43\1\50"+
    "\1\51\1\50\1\52\1\53\5\50\1\51\1\54\6\50"+
    "\1\51\20\50\1\36\1\37\2\36\1\40\5\36\1\37"+
    "\1\41\1\36\1\55\4\36\1\37\20\36\1\0\1\20"+
    "\10\0\1\20\7\0\1\20\20\0\1\17\1\20\4\17"+
    "\1\56\3\17\1\20\1\57\1\21\1\17\1\60\3\17"+
    "\1\20\20\17\1\61\1\20\6\61\1\62\1\61\1\20"+
    "\7\61\1\20\6\61\1\63\1\61\1\64\1\65\2\61"+
    "\1\66\3\61\1\67\1\70\10\67\1\70\7\67\1\70"+
    "\4\67\1\61\12\67\1\71\1\72\1\73\10\72\1\73"+
    "\7\72\1\73\5\72\1\61\11\72\1\74\22\75\1\0"+
    "\20\75\45\0\1\76\1\77\10\0\1\100\31\0\1\101"+
    "\6\102\6\0\1\102\1\103\2\0\1\102\4\0\11\102"+
    "\1\0\2\23\1\104\41\23\1\24\1\104\7\23\1\24"+
    "\7\23\1\24\23\23\1\105\11\23\1\106\25\23\1\0"+
    "\1\27\10\0\1\27\7\0\1\27\21\0\1\107\2\0"+
    "\6\110\1\107\1\110\1\0\1\111\3\0\1\110\1\107"+
    "\2\110\1\0\1\110\2\0\11\110\1\0\1\31\1\0"+
    "\13\31\1\112\4\31\1\0\21\31\1\0\3\31\1\113"+
    "\7\31\1\112\4\31\1\0\21\31\1\20\10\31\1\33"+
    "\2\31\1\112\4\31\1\20\21\31\1\0\2\31\1\114"+
    "\10\31\1\112\4\31\1\0\20\31\15\36\1\115\26\36"+
    "\1\37\10\36\1\37\2\36\1\115\4\36\1\37\25\36"+
    "\1\116\7\36\1\115\31\36\1\117\10\36\1\115\42\36"+
    "\1\35\25\36\3\43\1\120\40\43\1\44\1\43\1\120"+
    "\6\43\1\44\7\43\1\44\37\43\1\35\26\43\1\120"+
    "\1\43\1\121\40\43\1\120\1\122\36\43\3\50\1\123"+
    "\40\50\1\51\1\50\1\123\6\50\1\51\7\50\1\51"+
    "\35\50\1\35\30\50\1\123\1\50\1\124\40\50\1\123"+
    "\1\125\36\50\20\0\1\126\41\0\1\127\26\0\1\101"+
    "\6\102\1\0\1\130\4\0\1\102\1\103\2\0\1\102"+
    "\4\0\11\102\5\0\1\131\46\0\1\132\66\0\1\133"+
    "\47\0\1\134\6\0\1\135\35\0\27\136\1\137\12\136"+
    "\1\140\1\136\1\70\10\136\1\70\7\136\1\70\4\136"+
    "\1\137\12\136\1\140\27\136\1\141\12\136\1\140\30\142"+
    "\1\137\11\142\1\143\1\142\1\73\10\142\1\73\7\142"+
    "\1\73\5\142\1\137\11\142\1\143\30\142\1\144\11\142"+
    "\1\143\1\145\1\0\1\146\7\145\1\0\7\145\1\0"+
    "\20\145\1\147\1\0\1\150\7\147\1\0\1\147\1\0"+
    "\5\147\1\0\20\147\1\151\1\0\1\152\7\151\1\0"+
    "\7\151\1\0\20\151\4\0\6\102\6\0\1\102\3\0"+
    "\1\102\4\0\11\102\1\0\3\23\1\0\11\23\1\0"+
    "\25\23\15\0\1\153\1\0\1\154\40\0\1\155\26\0"+
    "\1\107\10\0\1\107\7\0\1\107\20\0\1\31\1\0"+
    "\4\31\1\156\6\31\1\112\4\31\1\0\21\31\1\0"+
    "\3\31\1\157\7\31\1\112\4\31\1\0\20\31\15\36"+
    "\1\0\33\36\1\160\6\36\1\115\32\36\1\161\7\36"+
    "\1\115\25\36\17\43\1\0\26\43\1\120\2\43\1\162"+
    "\37\43\1\120\1\43\1\163\35\43\15\50\1\0\30\50"+
    "\1\123\2\50\1\164\37\50\1\123\1\50\1\165\35\50"+
    "\4\0\6\166\12\0\2\166\3\0\11\166\5\0\6\167"+
    "\6\0\1\167\3\0\1\167\4\0\11\167\40\0\1\170"+
    "\12\0\1\171\70\0\1\172\46\0\1\173\10\0\1\174"+
    "\33\0\1\31\1\0\5\31\1\175\5\31\1\112\4\31"+
    "\1\0\21\31\1\0\4\31\1\176\6\31\1\112\4\31"+
    "\1\0\20\31\7\36\1\177\5\36\1\115\33\36\1\200"+
    "\6\36\1\115\25\36\3\43\1\120\3\43\1\201\36\43"+
    "\1\120\2\43\1\202\34\43\3\50\1\123\3\50\1\203"+
    "\36\50\1\123\2\50\1\204\34\50\4\0\6\166\12\0"+
    "\2\166\1\205\2\0\11\166\5\0\6\167\5\0\1\206"+
    "\1\167\3\0\1\167\4\0\11\167\10\0\1\207\71\0"+
    "\1\210\44\0\1\211\2\0\1\31\1\0\6\31\1\212"+
    "\4\31\1\112\4\31\1\0\21\31\1\0\5\31\1\213"+
    "\5\31\1\112\4\31\1\0\20\31\10\36\1\214\4\36"+
    "\1\115\34\36\1\215\5\36\1\115\25\36\3\43\1\120"+
    "\4\43\1\216\35\43\1\120\3\43\1\217\33\43\3\50"+
    "\1\123\4\50\1\220\35\50\1\123\3\50\1\221\33\50"+
    "\27\0\1\222\1\223\44\0\1\224\41\0\1\225\45\0"+
    "\1\226\6\0\1\31\1\0\7\31\1\227\3\31\1\112"+
    "\4\31\1\0\21\31\1\0\6\31\1\230\4\31\1\112"+
    "\4\31\1\0\20\31\11\36\1\231\3\36\1\115\35\36"+
    "\1\232\4\36\1\115\25\36\3\43\1\120\5\43\1\233"+
    "\34\43\1\120\4\43\1\234\32\43\3\50\1\123\5\50"+
    "\1\235\34\50\1\123\4\50\1\236\32\50\32\0\1\237"+
    "\16\0\1\240\34\0\1\31\1\0\10\31\1\241\2\31"+
    "\1\112\4\31\1\0\21\31\1\0\7\31\1\242\3\31"+
    "\1\112\4\31\1\0\20\31\12\36\1\243\2\36\1\115"+
    "\36\36\1\244\3\36\1\115\25\36\3\43\1\120\6\43"+
    "\1\245\33\43\1\120\5\43\1\246\31\43\3\50\1\123"+
    "\6\50\1\247\33\50\1\123\5\50\1\250\31\50\1\31"+
    "\1\0\6\31\1\251\1\31\1\241\2\31\1\112\4\31"+
    "\1\0\6\31\1\252\1\31\1\253\1\254\2\31\1\255"+
    "\3\31\10\36\1\256\1\36\1\243\2\36\1\115\13\36"+
    "\1\257\1\36\1\260\1\261\2\36\1\262\3\36\3\43"+
    "\1\120\4\43\1\263\1\43\1\245\16\43\1\264\1\43"+
    "\1\265\1\266\2\43\1\267\3\43\3\50\1\123\4\50"+
    "\1\270\1\50\1\247\16\50\1\271\1\50\1\272\1\273"+
    "\2\50\1\274\3\50\1\31\1\0\2\31\1\275\10\31"+
    "\1\112\4\31\1\0\21\31\1\0\6\31\1\276\4\31"+
    "\1\112\4\31\1\0\21\31\1\0\13\31\1\112\4\31"+
    "\1\0\11\31\1\277\7\31\1\0\13\31\1\112\4\31"+
    "\1\0\16\31\1\300\2\31\1\0\3\31\1\301\7\31"+
    "\1\112\4\31\1\0\20\31\4\36\1\302\10\36\1\115"+
    "\35\36\1\303\4\36\1\115\42\36\1\115\16\36\1\304"+
    "\23\36\1\115\23\36\1\305\6\36\1\306\7\36\1\115"+
    "\25\36\3\43\1\120\1\307\41\43\1\120\4\43\1\310"+
    "\35\43\1\120\30\43\1\311\11\43\1\120\35\43\1\312"+
    "\4\43\1\120\1\43\1\313\35\43\3\50\1\123\1\314"+
    "\41\50\1\123\4\50\1\315\35\50\1\123\30\50\1\316"+
    "\11\50\1\123\35\50\1\317\4\50\1\123\1\50\1\320"+
    "\35\50\1\31\1\0\13\31\1\112\4\31\1\0\14\31"+
    "\1\321\4\31\1\0\5\31\1\322\5\31\1\112\4\31"+
    "\1\0\21\31\1\0\13\31\1\112\4\31\1\0\12\31"+
    "\1\323\6\31\1\0\13\31\1\112\4\31\1\0\16\31"+
    "\1\324\2\31\1\0\5\31\1\325\5\31\1\112\4\31"+
    "\1\0\20\31\15\36\1\115\21\36\1\326\12\36\1\327"+
    "\5\36\1\115\42\36\1\115\17\36\1\330\22\36\1\115"+
    "\23\36\1\331\10\36\1\332\5\36\1\115\25\36\3\43"+
    "\1\120\33\43\1\333\6\43\1\120\3\43\1\334\36\43"+
    "\1\120\31\43\1\335\10\43\1\120\35\43\1\336\4\43"+
    "\1\120\3\43\1\337\33\43\3\50\1\123\33\50\1\340"+
    "\6\50\1\123\3\50\1\341\36\50\1\123\31\50\1\342"+
    "\10\50\1\123\35\50\1\343\4\50\1\123\3\50\1\344"+
    "\33\50\1\31\1\0\13\31\1\345\4\31\1\0\21\31"+
    "\1\0\5\31\1\346\5\31\1\112\4\31\1\0\21\31"+
    "\1\0\13\31\1\112\4\31\1\0\13\31\1\347\5\31"+
    "\1\0\13\31\1\350\4\31\1\0\21\31\1\0\13\31"+
    "\1\112\4\31\1\0\15\31\1\351\2\31\15\36\1\352"+
    "\34\36\1\353\5\36\1\115\42\36\1\115\20\36\1\354"+
    "\21\36\1\355\42\36\1\115\22\36\1\356\2\36\3\43"+
    "\1\120\11\43\1\357\30\43\1\120\3\43\1\360\36\43"+
    "\1\120\32\43\1\361\7\43\1\120\11\43\1\362\30\43"+
    "\1\120\34\43\1\363\2\43\3\50\1\123\11\50\1\364"+
    "\30\50\1\123\3\50\1\365\36\50\1\123\32\50\1\366"+
    "\7\50\1\123\11\50\1\367\30\50\1\123\34\50\1\370"+
    "\2\50\1\31\1\0\13\31\1\112\4\31\1\0\7\31"+
    "\1\371\11\31\1\0\13\31\1\112\4\31\1\0\6\31"+
    "\1\372\12\31\1\0\13\31\1\112\4\31\1\0\11\31"+
    "\1\373\6\31\15\36\1\115\14\36\1\374\25\36\1\115"+
    "\13\36\1\375\26\36\1\115\16\36\1\376\6\36\3\43"+
    "\1\120\26\43\1\377\13\43\1\120\25\43\1\u0100\14\43"+
    "\1\120\30\43\1\u0101\6\43\3\50\1\123\26\50\1\u0102"+
    "\13\50\1\123\25\50\1\u0103\14\50\1\123\30\50\1\u0104"+
    "\6\50\1\31\1\0\13\31\1\u0105\4\31\1\0\21\31"+
    "\1\0\13\31\1\112\4\31\1\0\7\31\1\u0106\11\31"+
    "\1\0\4\31\1\u0107\6\31\1\112\4\31\1\0\20\31"+
    "\15\36\1\u0108\42\36\1\115\14\36\1\u0109\16\36\1\u010a"+
    "\6\36\1\115\25\36\3\43\1\120\11\43\1\u010b\30\43"+
    "\1\120\26\43\1\u010c\13\43\1\120\2\43\1\u010d\34\43"+
    "\3\50\1\123\11\50\1\u010e\30\50\1\123\26\50\1\u010f"+
    "\13\50\1\123\2\50\1\u0110\34\50\1\31\1\0\13\31"+
    "\1\u0111\4\31\1\0\21\31\1\0\13\31\1\u0112\4\31"+
    "\1\0\20\31\15\36\1\u0113\42\36\1\u0114\25\36\3\43"+
    "\1\120\11\43\1\u0115\30\43\1\120\11\43\1\u0116\25\43"+
    "\3\50\1\123\11\50\1\u0117\30\50\1\123\11\50\1\u0118"+
    "\25\50";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7700];
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
    "\1\0\1\1\14\0\1\11\6\1\1\11\6\1\1\11"+
    "\17\1\1\0\3\1\1\11\13\1\2\11\3\0\1\1"+
    "\3\0\2\1\3\11\2\1\1\0\2\1\1\0\2\1"+
    "\1\0\2\1\1\0\1\11\7\0\1\11\1\0\1\1"+
    "\2\0\1\1\11\11\10\1\2\0\1\11\2\0\1\11"+
    "\1\0\10\1\1\0\1\11\3\0\10\1\3\11\2\0"+
    "\10\1\2\11\104\1\1\11\2\1\1\11\34\1\1\11"+
    "\13\1\2\11\6\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[280];
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

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

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
  private boolean zzAtEOF = false;

  /* user code: */

    private ByteStack stack = new ByteStack();
    private LexerInput input;
    private Syntax syntax;
    private ArrayDeque<HtmlTag> tags;

    public LatteTopColoringLexer(LexerRestartInfo info) {
        this.input = info.input();
        if (info.state() != null) {
            //reset state
            setState((LexerState) info.state());
            this.syntax = ((LexerState) info.state()).syntax;
            this.tags = ((LexerState) info.state()).tags.clone();
        } else {
            zzState = zzLexicalState = YYINITIAL;
            this.syntax = Syntax.LATTE;
            this.tags = new ArrayDeque<>() ;
            stack.clear();
        }

    }

    private boolean curlyInBalance(String text) {
        int textLength = text.length();
        int openCurly = textLength - text.replace("{", "").length();
        int closeCurly = textLength - text.replace("}", "").length();
        return openCurly == closeCurly;
    }

    private enum Syntax {
        LATTE,
        DOUBLE,
        ASP,
        PYTHON,
        OFF;
    }

    private static final class HtmlTag {
        private boolean isSyntax;

        public void setIsSyntax(boolean isSyntax) {
            this.isSyntax = isSyntax;
        }

        public boolean isSyntax() {
            return isSyntax;
        }

    }

    public static final class LexerState  {
        final ByteStack stack;
        /** the current state of the DFA */
        final int zzState;
        /** the current lexical state */
        final int zzLexicalState;
        private final Syntax syntax;
        private final ArrayDeque<HtmlTag> tags;

        LexerState(ByteStack stack, int zzState, int zzLexicalState, Syntax syntax, ArrayDeque<HtmlTag> tags) {
            this.stack = stack;
            this.zzState = zzState;
            this.zzLexicalState = zzLexicalState;
            this.syntax = syntax;
            this.tags = tags;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 89 * hash + Objects.hashCode(this.stack);
            hash = 89 * hash + this.zzState;
            hash = 89 * hash + this.zzLexicalState;
            hash = 89 * hash + (this.syntax != null ? this.syntax.hashCode() : 0);
            hash = 89 * hash + Objects.hashCode(this.tags);
            return hash;
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
            if (!Objects.equals(this.stack, other.stack)) {
                return false;
            }
            if (this.zzState != other.zzState) {
                return false;
            }
            if (this.zzLexicalState != other.zzLexicalState) {
                return false;
            }
            if (this.syntax != other.syntax) {
                return false;
            }
            if (!Objects.equals(this.tags, other.tags)) {
                return false;
            }
            return true;
        }
    }

    public LexerState getState() {
        return new LexerState(stack.copyOf(), zzState, zzLexicalState, syntax, tags.clone());
    }

    public void setState(LexerState state) {
        this.stack.copyFrom(state.stack);
        this.zzState = state.zzState;
        this.zzLexicalState = state.zzLexicalState;
    }

    protected int getZZLexicalState() {
        return zzLexicalState;
    }

    protected void popState() {
        yybegin(stack.pop());
    }

    protected void pushState(final int state) {
        stack.push(getZZLexicalState());
        yybegin(state);
    }


 // End user code



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LatteTopColoringLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LatteTopColoringLexer(java.io.InputStream in) {
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
    while (i < 162) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
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
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
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
    //zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  @SuppressWarnings("fallthrough")
  public LatteTopTokenId findNextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    //int zzCurrentPosL;
    //int zzMarkedPosL;
    //int zzEndReadL = zzEndRead;
    //char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      //zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      //zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
      int tokenLength = 0;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
            zzInput = input.read();

            if(zzInput == LexerInput.EOF) {
                //end of input reached
                zzInput = YYEOF;
                break zzForAction;
                //notice: currently LexerInput.EOF == YYEOF
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
        case 41:
          { if (yytext().endsWith("}")) {
            yypushback(1);
        }
        syntax = Syntax.PYTHON;
        return LatteTopTokenId.T_LATTE;
          }
        case 42: break;
        case 39:
          { if (yytext().endsWith("}")) {
            yypushback(1);
        }
        syntax = Syntax.LATTE;
        return LatteTopTokenId.T_LATTE;
          }
        case 43: break;
        case 10:
          { return LatteTopTokenId.T_LATTE_ERROR;
          }
        case 44: break;
        case 24:
          { if (yylength() > 3) {
            yypushback(3);
            return LatteTopTokenId.T_HTML;
        }
        if (syntax == Syntax.ASP) {
            pushState(ST_COMMENT);
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 45: break;
        case 6:
          { if (curlyInBalance(yytext())) {
            return LatteTopTokenId.T_LATTE;
        }
          }
        case 46: break;
        case 23:
          { if (yylength() > 3) {
            yypushback(3);
            return LatteTopTokenId.T_HTML;
        }
        yypushback(1);
        if (syntax == Syntax.ASP) {
            pushState(ST_ASP);
            return LatteTopTokenId.T_LATTE_OPEN_DELIMITER;
        }
          }
        case 47: break;
        case 16:
          { if (curlyInBalance(yytext().substring(0, yylength() - 1))) {
            yypushback(1);
            return LatteTopTokenId.T_LATTE;
        }
          }
        case 48: break;
        case 9:
          { yypushback(yylength());
        pushState(ST_HIGHLIGHTING_ERROR);
          }
        case 49: break;
        case 20:
          { if (yylength() > 3) {
            yypushback(3);
            return LatteTopTokenId.T_HTML;
        }
        if (syntax == Syntax.PYTHON) {
            pushState(ST_COMMENT);
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 50: break;
        case 31:
          { String text = yytext().toLowerCase().trim();
        String attributeName = text.substring(0, text.length() - 2);
        if (attributeName.endsWith("n:syntax")) { //NOI18N
            tags.peek().setIsSyntax(true);
            pushState(ST_IN_SYNTAX_ATTR);
        } else {
            pushState(ST_N_ATTR_DOUBLE);
        }
        return LatteTopTokenId.T_HTML;
          }
        case 51: break;
        case 30:
          { HtmlTag tag = tags.pop();
        if (tag.isSyntax()) {
            syntax = Syntax.LATTE;
        }
        popState();
          }
        case 52: break;
        case 28:
          { popState();
        syntax = Syntax.ASP;
        return LatteTopTokenId.T_LATTE;
          }
        case 53: break;
        case 34:
          { popState();
        syntax = Syntax.DOUBLE;
        return LatteTopTokenId.T_LATTE;
          }
        case 54: break;
        case 37:
          { if (yytext().endsWith("}")) {
            yypushback(1);
        }
        syntax = Syntax.ASP;
        return LatteTopTokenId.T_LATTE;
          }
        case 55: break;
        case 11:
          { if (yylength() > 2) {
            yypushback(2);
            return LatteTopTokenId.T_HTML;
        }
        if (syntax == Syntax.LATTE) {
            pushState(ST_COMMENT);
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 56: break;
        case 14:
          { if (yylength() > 2) {
            yypushback(2);
            return LatteTopTokenId.T_HTML;
        }
        yypushback(1);
        if (syntax == Syntax.LATTE) {
            pushState(ST_LATTE);
            return LatteTopTokenId.T_LATTE_OPEN_DELIMITER;
        } else {
            popState();
            return LatteTopTokenId.T_HTML;
        }
          }
        case 57: break;
        case 18:
          { yypushback(1);
        popState();
        return LatteTopTokenId.T_LATTE;
          }
        case 58: break;
        case 29:
          { popState();
        syntax = Syntax.OFF;
        return LatteTopTokenId.T_LATTE;
          }
        case 59: break;
        case 3:
          { yypushback(1);
        pushState(ST_POSSIBLE_LATTE);
          }
        case 60: break;
        case 25:
          { if (syntax == Syntax.PYTHON) {
            popState();
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 61: break;
        case 38:
          { if (yytext().endsWith("}")) {
            yypushback(1);
        }
        syntax = Syntax.OFF;
        return LatteTopTokenId.T_LATTE;
          }
        case 62: break;
        case 4:
          { yypushback(yylength());
        popState();
          }
        case 63: break;
        case 1:
          { return LatteTopTokenId.T_LATTE_COMMENT;
          }
        case 64: break;
        case 12:
          { tags.push(new HtmlTag());
        pushState(ST_IN_HTML_TAG);
          }
        case 65: break;
        case 21:
          { if (yylength() > 3) {
            yypushback(3);
            return LatteTopTokenId.T_HTML;
        }
        yypushback(1);
        if (syntax == Syntax.DOUBLE) {
            pushState(ST_DOUBLE);
            return LatteTopTokenId.T_LATTE_OPEN_DELIMITER;
        }
        if (syntax == Syntax.PYTHON) {
            pushState(ST_PYTHON_DOUBLE);
            return LatteTopTokenId.T_LATTE_OPEN_DELIMITER;
        }
        if (syntax == Syntax.LATTE) {
            yypushback(1);
        }
          }
        case 66: break;
        case 5:
          { popState();
          }
        case 67: break;
        case 15:
          { yypushback(1);
        popState();
        return LatteTopTokenId.T_HTML;
          }
        case 68: break;
        case 8:
          { return LatteTopTokenId.T_LATTE;
          }
        case 69: break;
        case 40:
          { if (yytext().endsWith("}")) {
            yypushback(1);
        }
        syntax = Syntax.DOUBLE;
        return LatteTopTokenId.T_LATTE;
          }
        case 70: break;
        case 35:
          { popState();
        syntax = Syntax.PYTHON;
        return LatteTopTokenId.T_LATTE;
          }
        case 71: break;
        case 27:
          { if (syntax == Syntax.DOUBLE || syntax == Syntax.PYTHON) {
            popState();
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 72: break;
        case 17:
          { if (!tags.isEmpty()) {
            HtmlTag tag = tags.pop();
            if (tag.isSyntax()) {
                syntax = Syntax.LATTE;
            }
        }
        popState();
          }
        case 73: break;
        case 32:
          { String text = yytext().toLowerCase().trim();
        String attributeName = text.substring(0, text.length() - 2);
        if (attributeName.endsWith("n:syntax")) { //NOI18N
            tags.peek().setIsSyntax(true);
            pushState(ST_IN_SYNTAX_ATTR);
        } else {
            pushState(ST_N_ATTR_SINGLE);
        }
        return LatteTopTokenId.T_HTML;
          }
        case 74: break;
        case 36:
          { syntax = Syntax.LATTE;
        return LatteTopTokenId.T_LATTE;
          }
        case 75: break;
        case 7:
          { popState();
        return LatteTopTokenId.T_LATTE_CLOSE_DELIMITER;
          }
        case 76: break;
        case 26:
          { if (syntax == Syntax.ASP) {
            popState();
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 77: break;
        case 19:
          { if (yylength() > 3) {
            yypushback(3);
            return LatteTopTokenId.T_HTML;
        }
        yypushback(1);
        if (syntax == Syntax.PYTHON) {
            pushState(ST_PYTHON);
            return LatteTopTokenId.T_LATTE_OPEN_DELIMITER;
        }
          }
        case 78: break;
        case 13:
          { if (syntax == Syntax.LATTE) {
            popState();
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 79: break;
        case 22:
          { if (yylength() > 3) {
            yypushback(3);
            return LatteTopTokenId.T_HTML;
        }
        if (syntax == Syntax.DOUBLE || syntax == Syntax.PYTHON) {
            pushState(ST_COMMENT);
            return LatteTopTokenId.T_LATTE_COMMENT_DELIMITER;
        }
          }
        case 80: break;
        case 33:
          { popState();
        syntax = Syntax.LATTE;
        return LatteTopTokenId.T_LATTE;
          }
        case 81: break;
        case 2:
          {
          }
        case 82: break;
        default:
          if (zzInput == YYEOF)
            //zzAtEOF = true;
              {         if (input.readLength() > 0) {
            // backup eof
            input.backup(1);
            //and return the text as HTML token
            return LatteTopTokenId.T_HTML;
        } else {
            return null;
        }
 }

          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
