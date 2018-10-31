-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 31 Octobre 2018 à 10:55
-- Version du serveur :  5.6.20-log
-- Version de PHP :  5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `stageo`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE IF NOT EXISTS `adresse` (
  `ID_ADRESSE` varchar(64) NOT NULL,
  `NUMERO_CIVIQUE` varchar(16) NOT NULL,
  `RUE` varchar(64) NOT NULL,
  `BUREAU` varchar(8) NOT NULL,
  `VILLE` varchar(64) NOT NULL,
  `CODE_POSTAL` varchar(16) NOT NULL,
  `PROVINCE` varchar(32) NOT NULL,
  `PAYS` varchar(32) NOT NULL DEFAULT 'Canada',
  `TEL` varchar(16) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE IF NOT EXISTS `candidature` (
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `ID_OFFRE` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL,
  `STATUT` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compagnie`
--

CREATE TABLE IF NOT EXISTS `compagnie` (
  `ID_COMPAGNIE` varchar(64) NOT NULL,
  `NOM` varchar(128) NOT NULL,
  `SITE_WEB` varchar(256) NOT NULL,
  `ID_ADRESSE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `coordonnateur`
--

CREATE TABLE IF NOT EXISTS `coordonnateur` (
  `ID_COORDONNATEUR` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `critere`
--

CREATE TABLE IF NOT EXISTS `critere` (
  `ID_CRITERE` varchar(64) NOT NULL,
  `NOM` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cv`
--

CREATE TABLE IF NOT EXISTS `cv` (
  `ID_CV` varchar(64) NOT NULL,
  `LIEN` varchar(256) NOT NULL,
  `LANGUE` varchar(32) NOT NULL,
  `NB_VUES` int(11) NOT NULL,
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `ID_DOCUMENT` varchar(64) NOT NULL,
  `LIEN` varchar(32) NOT NULL,
  `TYPE` varchar(128) NOT NULL,
  `NB_VUES` int(11) NOT NULL,
  `ID_COORDONNATEUR` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `employeur`
--

CREATE TABLE IF NOT EXISTS `employeur` (
  `ID_EMPLOYEUR` varchar(64) NOT NULL,
  `TEL` varchar(16) NOT NULL,
  `ID_COMPAGNIE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `STATUT_RECHERCHE` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiantcritere`
--

CREATE TABLE IF NOT EXISTS `etudiantcritere` (
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `ID_CRITERE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `ID_MESSAGE` varchar(64) NOT NULL,
  `TITRE` varchar(128) NOT NULL,
  `MESSAGE` varchar(512) NOT NULL,
  `VU` tinyint(4) NOT NULL,
  `DATE` timestamp NOT NULL,
  `HEURE` time NOT NULL,
  `ID_EXPEDITEUR` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `ID_NOTIFICATION` varchar(64) NOT NULL,
  `TYPE` varchar(128) NOT NULL,
  `MESSAGE` varchar(256) NOT NULL,
  `VUE` tinyint(4) NOT NULL,
  `ID_COORDONNATEUR` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL,
  `HEURE` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offrestage`
--

CREATE TABLE IF NOT EXISTS `offrestage` (
  `ID_OFFRE` varchar(64) NOT NULL,
  `TITRE` varchar(256) NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `LIEN_WEB` varchar(256) NOT NULL,
  `LIEN_DOCUMENT` varchar(128) NOT NULL,
  `DATE` timestamp NOT NULL,
  `NB_VUES` int(11) NOT NULL,
  `ACTIVE` tinyint(4) NOT NULL,
  `ID_EMPLOYEUR` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offrestagecritere`
--

CREATE TABLE IF NOT EXISTS `offrestagecritere` (
  `ID_OFFRE` varchar(64) NOT NULL,
  `ID_CRITERE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_UTILISATEUR` varchar(64) NOT NULL,
  `COURRIEL` varchar(128) NOT NULL,
  `MOT_DE_PASSE` varchar(128) NOT NULL,
  `NOM` varchar(64) NOT NULL,
  `PRENOM` varchar(64) NOT NULL,
  `TYPE_UTILISATEUR` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurmessage`
--

CREATE TABLE IF NOT EXISTS `utilisateurmessage` (
  `ID_MESSAGE` varchar(64) NOT NULL,
  `ID_DESTINATAIRE` varchar(64) NOT NULL,
  `LU` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
 ADD PRIMARY KEY (`ID_ADRESSE`);

--
-- Index pour la table `candidature`
--
ALTER TABLE `candidature`
 ADD PRIMARY KEY (`ID_ETUDIANT`,`ID_OFFRE`);

--
-- Index pour la table `compagnie`
--
ALTER TABLE `compagnie`
 ADD PRIMARY KEY (`ID_COMPAGNIE`);

--
-- Index pour la table `coordonnateur`
--
ALTER TABLE `coordonnateur`
 ADD PRIMARY KEY (`ID_COORDONNATEUR`);

--
-- Index pour la table `critere`
--
ALTER TABLE `critere`
 ADD PRIMARY KEY (`ID_CRITERE`);

--
-- Index pour la table `cv`
--
ALTER TABLE `cv`
 ADD PRIMARY KEY (`ID_CV`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
 ADD PRIMARY KEY (`ID_DOCUMENT`);

--
-- Index pour la table `employeur`
--
ALTER TABLE `employeur`
 ADD PRIMARY KEY (`ID_EMPLOYEUR`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
 ADD PRIMARY KEY (`ID_ETUDIANT`);

--
-- Index pour la table `etudiantcritere`
--
ALTER TABLE `etudiantcritere`
 ADD PRIMARY KEY (`ID_ETUDIANT`,`ID_CRITERE`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
 ADD PRIMARY KEY (`ID_MESSAGE`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
 ADD PRIMARY KEY (`ID_NOTIFICATION`);

--
-- Index pour la table `offrestage`
--
ALTER TABLE `offrestage`
 ADD PRIMARY KEY (`ID_OFFRE`);

--
-- Index pour la table `offrestagecritere`
--
ALTER TABLE `offrestagecritere`
 ADD PRIMARY KEY (`ID_OFFRE`,`ID_CRITERE`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
 ADD PRIMARY KEY (`ID_UTILISATEUR`), ADD UNIQUE KEY `COURRIEL` (`COURRIEL`);

--
-- Index pour la table `utilisateurmessage`
--
ALTER TABLE `utilisateurmessage`
 ADD PRIMARY KEY (`ID_MESSAGE`,`ID_DESTINATAIRE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
