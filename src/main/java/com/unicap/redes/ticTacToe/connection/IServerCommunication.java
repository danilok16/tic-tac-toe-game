package com.unicap.redes.tictactoe.connection;

public interface IServerCommunication {
    void login (String nickname);
    void logout();
    void challengePlayer(int opponentId);
    void acceptChallenge();
    void makeMove(int movePosition);
}
