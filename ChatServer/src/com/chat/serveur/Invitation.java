package com.chat.serveur;

import com.commun.net.Connexion;

import java.util.ArrayList;

public class Invitation {
    String aliasHost;
    String aliasGuest;

    public Invitation(Connexion connexion, String aliasGuest) {
        this.aliasHost = connexion.getAlias();
        this.aliasGuest = aliasGuest;
    }

    public String getAliasHost() {
        return aliasHost;
    }

    public void setAliasHost(String aliasHost) {
        this.aliasHost = aliasHost;
    }

    public String getAliasGuest() {
        return aliasGuest;
    }

    public void setAliasGuest(String aliasGuest) {
        this.aliasGuest = aliasGuest;
    }

    public ArrayList<Invitation> addInvitation(ArrayList<Invitation> inviteList, Invitation invite) {
        inviteList.add(invite);
        return inviteList;
    }
}
