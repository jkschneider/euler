package com.euler.p18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class TreeReader {
  public static BinaryNode parse(String rawTree) {
    BinaryNode root = new BinaryNode();

    BufferedReader reader = new BufferedReader(new StringReader(rawTree));
    try {
      int previousLine = 0;
      BinaryNode[] previousLineNodes = null;

      String line = null;
      while ((line = reader.readLine()) != null) {
        if (previousLine == 0) {
          root.weight = Long.parseLong(line);
          previousLineNodes = new BinaryNode[]{root};
        } else {
          String[] segments = line.split(" ");
          BinaryNode[] lineNodes = new BinaryNode[segments.length];

          for (int i = 0; i < segments.length; i++) {
            BinaryNode node = new BinaryNode();
            node.weight = Long.parseLong(segments[i]);
            lineNodes[i] = node;
          }

          for (int i = 0; i < segments.length - 1; i++) {
            previousLineNodes[i].left = lineNodes[i];
            previousLineNodes[i].right = lineNodes[i + 1];
          }

          previousLineNodes = lineNodes;
        }

        previousLine++;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return root;
  }
}
