package com.chat.commun.thread;
/**
 * Cette classe permet de cr�er des threads capables de lire continuellement sur un un objet de type Lecteur.
 *
 * @author Abdelmoum�ne Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-09-01
 */
public class ThreadEcouteurDeTexte extends Thread {
	Lecteur lecteur;

	/**
	 * Construit un thread sur un lecteur
	 * @param lecteur Le lecteur sur lequel le thread va lire
	 */
	public ThreadEcouteurDeTexte(Lecteur lecteur)
	 {
		 this.lecteur = lecteur;
	 }

	/**
	 * M�thode principale du thread. Cette m�thode appelle continuellement la m�thode lire() du
	 * lecteur (client ou serveur)
	 */
	public void run()
	 {
		while (!interrupted())
		{
			lecteur.lire();
			try
			{
			  Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				break;
			}			
		}
	 }
}
