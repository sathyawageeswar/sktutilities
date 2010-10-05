package com.sktUtilities.chandoviciti;

import java.util.HashMap;
import java.util.LinkedList;

import com.sktutilities.util.EncodingUtil;

public class MetricAnalyzer
{
    public MetricAnalyzer()
    {
        // Refer to
        // http://cs.annauniv.edu/insight/insight/chhandas/pages/typepage.htm
    }

    public LinkedList<MetricAnalysisBean>  analyzeVarnaFrequency(String metricStringInSLP)
    /*
     * @param metricString will alwayts be in SLP Encoding
     */

    {
        @SuppressWarnings("unused")
        String report = "Report of Frequency of Varnas: \n";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char varna : metricStringInSLP.toCharArray())
        {

            if (map.containsKey(varna))
            {
                int i = map.get(varna) + 1;
                map.put(varna, i);
                // System.out.println("Adding Varna " + varna + " for " + i + "
                // Time");
            }

            else
            {
                // System.out.println("Adding Varna " + varna + " for First
                // Time");
                map.put(varna, 1);
            }
        }

        LinkedList<MetricAnalysisBean> list = new LinkedList<MetricAnalysisBean>();
        for (char varna : map.keySet())
        {
            String varnaAsString = String.valueOf(varna);

            if (Character.isSpaceChar(varna))
            {
                varnaAsString = "Space";
            }

            else if (varna == '\n')
            {
                varnaAsString = "New Line Character";
            }

            else if (varna == 'H')
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari("visarga(aH)");
            }

            else if (varna == 'M')
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari("anusvAra(aM)");
            }

            else if (varna == '~')
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari("anunAsika(a~)");
            }
            else if (varna == '\'')
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari("avagraha(\')");
            }
            else if (varna == '3')
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari("pluta(3)");
            }

            else if (varna == '8')
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari("upaDAmanIya(8)");
            }
            else
            {
                varnaAsString = EncodingUtil.convertSLPToDevanagari(varnaAsString);
            }
            MetricAnalysisBean bean = new MetricAnalysisBean();
            bean.setVarna(varnaAsString);
            bean.setFrequency(map.get(varna).toString());
            list.add(bean);
        }

        return list;
    }

    public void analyzeMetrically(String metricString)
    {
        /*
         * http://cs.annauniv.edu/insight/insight/chhandas/pages/typepage.htm
         * Rules: 1. A syllable can be short (laghu) or long (guru) according to
         * whether its vowel is short or long. The vowels (a,i,u,r,lr) are
         * short, and the vowels (aa,ee,uu,e,ai,o,ou) are long. Also, a short
         * vowel can become long when it is followed by anusvaaram (am) or
         * visargam (aH). Moreover, if a conjunct consonant (i.e, a half
         * consonant, one that is not attached to any vowel - called
         * samyuktaakShara in Sanskrit) follows a short or a long vowel, the
         * whole syllable is considered long.
         * 
         * 2 . A laghu, when it appears at the end of a paadam, can optionally
         * be treated as a guru, if it helps in grouping the syllables properly.
         * We shall indicate to you when such situation arises.)
         */

    }

    public static void main(String args[])
    {
        String meterINSLP = "evamuktvArjunaH saNKye raTopasT upAviSat\nvisfjya saSaraM cApaM SokasaMvignamAnasaH";
        new MetricAnalyzer().analyzeVarnaFrequency(meterINSLP);
    }
}
