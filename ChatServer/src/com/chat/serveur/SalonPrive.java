package com.chat.serveur;

import com.commun.net.Connexion;

public class SalonPrive {
    String aliasHost;
    String aliasGuest;

    public SalonPrive(Connexion connexion, String aliasGuest) {
        this.aliasGuest = aliasGuest;
        this.aliasHost = connexion.getAlias();
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

    public boolean equals(SalonPrive s1, SalonPrive s2) {
        String s1Host = s1.getAliasHost();
        String s2Host = s2.getAliasHost();
        String s1Guest = s1.getAliasGuest();
        String s2Guest = s2.getAliasGuest();
        if(s1Host.equals(s2Host) || s1Guest.equals(s2Guest) || s1Host.equals(s2Guest) || s1Guest.equals(s2Host)){
            return true;
        } else return false;
    }
}
