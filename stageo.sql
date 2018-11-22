-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 03 Novembre 2018 à 17:14
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `stageo`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
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

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`ID_ADRESSE`, `NUMERO_CIVIQUE`, `RUE`, `BUREAU`, `VILLE`, `CODE_POSTAL`, `PROVINCE`, `PAYS`, `TEL`) VALUES
('A1', '984', 'train', '54', 'Montréal', 'T6Y 7U9', 'Québec', 'Canada', '5146689898'),
('A2', '574', 'Avion', '58', 'Longueuil', 'T6T 7Z3', 'Québec', 'Canada', '5147896565'),
('A3', '451', 'le roi', '841', 'Laval', 'H6Y 8U6', 'Québec', 'Canada', '5143754525');

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE `candidature` (
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `ID_OFFRE` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `STATUT` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidature`
--

INSERT INTO `candidature` (`ID_ETUDIANT`, `ID_OFFRE`, `DATE`, `STATUT`) VALUES
('B1', 'C2', '2018-11-03 16:21:44', 'Reçu'),
('B2', 'c3', '2018-11-03 16:21:44', 'Envoyer'),
('B3', 'C1', '2018-11-03 16:22:07', 'Envoyer');

-- --------------------------------------------------------

--
-- Structure de la table `compagnie`
--

CREATE TABLE `compagnie` (
  `ID_COMPAGNIE` varchar(64) NOT NULL,
  `NOM` varchar(128) NOT NULL,
  `SITE_WEB` varchar(256) NOT NULL,
  `ID_ADRESSE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compagnie`
--

INSERT INTO `compagnie` (`ID_COMPAGNIE`, `NOM`, `SITE_WEB`, `ID_ADRESSE`) VALUES
('D1', 'Google', 'www.Google.ca', 'A1'),
('D2', 'Netflix', 'WWW.netflix.ca', 'A2'),
('D3', 'Ubisoft', 'WWW.ubisoft.ca', 'A3');

-- --------------------------------------------------------

--
-- Structure de la table `coordonnateur`
--

CREATE TABLE `coordonnateur` (
  `ID_COORDONNATEUR` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `coordonnateur`
--

INSERT INTO `coordonnateur` (`ID_COORDONNATEUR`) VALUES
('E1'),
('E2'),
('E3');

-- --------------------------------------------------------

--
-- Structure de la table `critere`
--

CREATE TABLE `critere` (
  `ID_CRITERE` varchar(64) NOT NULL,
  `NOM` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `critere`
--

INSERT INTO `critere` (`ID_CRITERE`, `NOM`) VALUES
('F1', 'Critere_1'),
('F2', 'Critere_2'),
('F3', 'Critere_3');

-- --------------------------------------------------------

--
-- Structure de la table `cv`
--

CREATE TABLE `cv` (
  `ID_CV` varchar(64) NOT NULL,
  `LIEN` varchar(256) NOT NULL,
  `LANGUE` varchar(32) NOT NULL,
  `NB_VUES` int(11) NOT NULL,
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cv`
--

INSERT INTO `cv` (`ID_CV`, `LIEN`, `LANGUE`, `NB_VUES`, `ID_ETUDIANT`, `DATE`) VALUES
('G1', 'Lien_1', 'Français', 8, 'J3', '2018-11-03 16:33:14'),
('G2', 'Lien_2', 'Anglais', 1, 'J1', '2018-11-03 16:33:14'),
('G3', 'Lien_3', 'Français', 5, 'J2', '2018-11-03 16:33:45');

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `ID_DOCUMENT` varchar(64) NOT NULL,
  `LIEN` varchar(32) NOT NULL,
  `TYPE` varchar(128) NOT NULL,
  `NB_VUES` int(11) NOT NULL,
  `ID_COORDONNATEUR` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `document`
--

INSERT INTO `document` (`ID_DOCUMENT`, `LIEN`, `TYPE`, `NB_VUES`, `ID_COORDONNATEUR`, `DATE`) VALUES
('H1', 'Lien_4', 'PDF', 5, 'E2', '2018-11-03 16:37:16'),
('H2', 'Lien_5', 'DOCX', 1, 'E3', '2018-11-03 16:37:16'),
('H3', 'Lien_6', 'PDF', 0, 'E1', '2018-11-03 16:37:48');

-- --------------------------------------------------------

--
-- Structure de la table `employeur`
--

CREATE TABLE `employeur` (
  `ID_EMPLOYEUR` varchar(64) NOT NULL,
  `TEL` varchar(16) NOT NULL,
  `ID_COMPAGNIE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employeur`
--

INSERT INTO `employeur` (`ID_EMPLOYEUR`, `TEL`, `ID_COMPAGNIE`) VALUES
('I1', '5147594545', 'E1'),
('I2', '5147419292', 'E3'),
('I3', '5149348624', 'E2');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `STATUT_RECHERCHE` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_ETUDIANT`, `STATUT_RECHERCHE`) VALUES
('J1', 'En cour'),
('J2', 'En attente'),
('J3', 'Fini');

-- --------------------------------------------------------

--
-- Structure de la table `etudiantcritere`
--

CREATE TABLE `etudiantcritere` (
  `ID_ETUDIANT` varchar(64) NOT NULL,
  `ID_CRITERE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiantcritere`
--

INSERT INTO `etudiantcritere` (`ID_ETUDIANT`, `ID_CRITERE`) VALUES
('J1', 'F3'),
('J2', 'F1'),
('J3', 'F2');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `ID_MESSAGE` varchar(64) NOT NULL,
  `TITRE` varchar(128) NOT NULL,
  `MESSAGE` varchar(512) NOT NULL,
  `VU` tinyint(4) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `HEURE` time NOT NULL,
  `ID_EXPEDITEUR` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`ID_MESSAGE`, `TITRE`, `MESSAGE`, `VU`, `DATE`, `HEURE`, `ID_EXPEDITEUR`) VALUES
('K1', 'Rencontre', 'Je voudrais vous rencontrer', 0, '2018-11-03 16:49:37', '07:15:17', 'E3'),
('K2', 'Presentation', 'Je voudrais me présenter', 1, '2018-11-03 16:49:37', '15:02:45', 'J1'),
('K3', 'Candidature', 'Votre candidature va être étudier', 0, '2018-11-03 16:51:25', '15:01:56', 'J2');

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `ID_NOTIFICATION` varchar(64) NOT NULL,
  `TYPE` varchar(128) NOT NULL,
  `MESSAGE` varchar(256) NOT NULL,
  `VUE` tinyint(4) NOT NULL,
  `ID_COORDONNATEUR` varchar(64) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `HEURE` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `notification`
--

INSERT INTO `notification` (`ID_NOTIFICATION`, `TYPE`, `MESSAGE`, `VUE`, `ID_COORDONNATEUR`, `DATE`, `HEURE`) VALUES
('L1', 'Message', 'Vous avez recu un message', 0, 'E3', '2018-11-03 16:53:06', '10:19:12'),
('L2', 'Alert', 'Vous avez une rencontre', 1, 'E2', '2018-11-03 16:53:06', '08:46:00'),
('L3', 'Alert', 'Il vous reste 2 jour pour trouver un stage', 1, 'E1', '2018-11-03 16:54:27', '19:08:10');

-- --------------------------------------------------------

--
-- Structure de la table `offrestage`
--

CREATE TABLE `offrestage` (
  `ID_OFFRE` varchar(64) NOT NULL,
  `TITRE` varchar(256) NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `LIEN_WEB` varchar(256) NOT NULL,
  `LIEN_DOCUMENT` varchar(128) NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NB_VUES` int(11) NOT NULL,
  `ACTIVE` tinyint(4) NOT NULL,
  `ID_EMPLOYEUR` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `offrestage`
--

INSERT INTO `offrestage` (`ID_OFFRE`, `TITRE`, `DESCRIPTION`, `LIEN_WEB`, `LIEN_DOCUMENT`, `DATE`, `NB_VUES`, `ACTIVE`, `ID_EMPLOYEUR`) VALUES
('C1', 'Programmeur', 'Nous avons besoin d\'un programmeur en Java', 'WWW.UnSite.com', 'Lien_7', '2018-11-03 17:00:22', 8, 1, 'I2'),
('C2', 'Réseaux', 'Poste de gestionnaire réseaux', 'WWW.UnSite.com', 'Lien_8', '2018-11-03 17:00:22', 0, 0, 'I3'),
('C3', 'Technicien', 'Nous avons besoin d\'aide dans notre departement informatique', 'WWW.UnSite.com', 'Lien_9', '2018-11-03 17:03:27', 2, 1, 'E1');

-- --------------------------------------------------------

--
-- Structure de la table `offrestagecritere`
--

CREATE TABLE `offrestagecritere` (
  `ID_OFFRE` varchar(64) NOT NULL,
  `ID_CRITERE` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `offrestagecritere`
--

INSERT INTO `offrestagecritere` (`ID_OFFRE`, `ID_CRITERE`) VALUES
('C1', 'F3'),
('C2', 'F1'),
('C3', 'F2');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `ID_UTILISATEUR` varchar(64) NOT NULL,
  `COURRIEL` varchar(128) NOT NULL,
  `MOT_DE_PASSE` varchar(128) NOT NULL,
  `NOM` varchar(64) NOT NULL,
  `PRENOM` varchar(64) NOT NULL,
  `TYPE_UTILISATEUR` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `COURRIEL`, `MOT_DE_PASSE`, `NOM`, `PRENOM`, `TYPE_UTILISATEUR`) VALUES
('E1', 'Steve@hotmail.com', '1234', 'Steve', 'Steve', 'Coordonateur'),
('J3', 'Bob@gmail.com', '1234', 'avec cheveux', 'Bob', 'etudiant'),
('I2', 'Dom@outlook.com', '1234', 'Super', 'Dominique', 'employeur');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurmessage`
--

CREATE TABLE `utilisateurmessage` (
  `ID_MESSAGE` varchar(64) NOT NULL,
  `ID_DESTINATAIRE` varchar(64) NOT NULL,
  `LU` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateurmessage`
--

INSERT INTO `utilisateurmessage` (`ID_MESSAGE`, `ID_DESTINATAIRE`, `LU`) VALUES
('K1', 'E2', 0),
('', '', 0),
('K2', 'J3', 0),
('K3', 'I2', 1);

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
  ADD PRIMARY KEY (`ID_UTILISATEUR`),
  ADD UNIQUE KEY `COURRIEL` (`COURRIEL`);

--
-- Index pour la table `utilisateurmessage`
--
ALTER TABLE `utilisateurmessage`
  ADD PRIMARY KEY (`ID_MESSAGE`,`ID_DESTINATAIRE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
