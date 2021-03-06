/*
* Copyright (c) 2012 The Broad Institute
* 
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
* THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package org.broadinstitute.gatk.utils.commandline;

/**
 * Which source and the index within the source where an argument match was found.
 */
public class ArgumentMatchSite implements Comparable<ArgumentMatchSite> {
    private final ArgumentMatchSource source;
    private final int index;

    public ArgumentMatchSite(ArgumentMatchSource source, int index) {
        this.source = source;
        this.index = index;
    }

    public ArgumentMatchSource getSource() {
        return source;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArgumentMatchSite that = (ArgumentMatchSite) o;

        return (index == that.index) && (source == null ? that.source == null : source.equals(that.source));
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        // Generated by intellij. No other special reason to this implementation. -ks
        result = 31 * result + index;
        return result;
    }

    @Override
    public int compareTo(ArgumentMatchSite that) {
        int comp = this.source.compareTo(that.source);
        if (comp != 0)
            return comp;

        // Both files are the same.
        if (this.index == that.index)
            return 0;
        return this.index < that.index ? -1 : 1;
    }
}
