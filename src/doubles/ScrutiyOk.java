package doubles;

import data.VotingOption;
import services.Scrutiny;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScrutiyOk implements Scrutiny {

    private Map<VotingOption, Integer> votesCount;
    private int totalVotes;
    private int nullVotes;
    private int blankVotes;

    @Override
    public void initVoteCount(List<VotingOption> validParties) {
        votesCount = new HashMap<>();
        totalVotes = 0;
        nullVotes = 0;
        blankVotes = 0;

        if(validParties != null) {
            for (VotingOption party : validParties) {
                votesCount.put(party, 0);
            }
        }
        totalVotes = validParties.size();
    }

    @Override
    public void scrutinize(VotingOption vopt) {
        if (vopt == null) {
            nullVotes++;
        } else if ("NULO".equals(vopt.getParty())) {
            nullVotes++;
        } else if ("BLANCO".equals(vopt.getParty())) {
            blankVotes++;
        } else {
            int vot = votesCount.get(vopt);
            votesCount.put(vopt, vot +1 );
        }
    }

    @Override
    public int getVotesFor(VotingOption vopt) {
        return votesCount.getOrDefault(vopt, 0);
    }

    @Override
    public int getTotal() {
        return totalVotes;
    }

    @Override
    public int getNulls() {
        return nullVotes;
    }

    @Override
    public int getBlanks() {
        return blankVotes;
    }

    @Override
    public void getScrutinyResults() {
        for (VotingOption party : votesCount.keySet()) {
            System.out.print(party.toString() + ": " + votesCount.get(party) + "\n");
        }
        System.out.println("Votos totales: " + totalVotes);
        System.out.println("Votos en blancos: " + blankVotes);
        System.out.println("Votos nulos: " + nullVotes);
    }
}
