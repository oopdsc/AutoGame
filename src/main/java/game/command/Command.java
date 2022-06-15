package game.command;

import game.Player;

public interface Command {
    public String getAction(Player player);
}
