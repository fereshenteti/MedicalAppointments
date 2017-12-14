-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 13 Décembre 2017 à 22:45
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cabinet`
--

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id_medecin` int(11) NOT NULL,
  `nom` varchar(63) NOT NULL,
  `prenom` varchar(63) NOT NULL,
  `grade` varchar(63) NOT NULL,
  `specialite` varchar(63) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '1',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medecin`
--

INSERT INTO `medecin` (`id_medecin`, `nom`, `prenom`, `grade`, `specialite`, `actif`, `username`, `password`) VALUES
(1, 'Mammer', 'Rihab', 'Docteur', 'Chirurgie', 1, '', ''),
(2, 'Ben', 'Salah', 'Infirmier', 'Biologie', 1, '', ''),
(3, 'Graja', 'Oumayma', 'Docteur', 'Psychologue', 1, '', ''),
(4, 'Henteti', 'Feres', 'Docteur', 'Chirurgie', 0, '', ''),
(5, 'Ben', 'Sallah', 'assistant', 'chirurgie', 1, '', '');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL,
  `nom` varchar(63) NOT NULL,
  `prenom` varchar(63) NOT NULL,
  `fonction` varchar(63) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `nom`, `prenom`, `fonction`, `age`) VALUES
(1, 'Ben ', 'Salah', 'etudiant', 22),
(2, 'Gagoba ', 'Narcisse', 'etudiant', 24),
(3, 'Ali', 'Kammoun', 'etudi', 22),
(4, 'Henteti', 'Feres', 'ingenieur', 24),
(5, 'Abalo', 'Koffi', 'Mecanicien', 33),
(6, 'Afi', 'afi', 'Revendeuse', 44);

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE `rdv` (
  `id_rdv` int(11) NOT NULL,
  `date_rdv` date NOT NULL,
  `tranche_heure` varchar(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_medecin` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `rdv`
--

INSERT INTO `rdv` (`id_rdv`, `date_rdv`, `tranche_heure`, `id_patient`, `id_medecin`) VALUES
(1, '2017-11-24', '09H30-10H00', 1, 2),
(2, '2017-12-01', '09H30-10H00', 3, 2),
(4, '2017-12-30', '11H00-11H30', 1, 4),
(5, '2017-09-12', '09H30-10H00', 1, 4),
(6, '2017-12-14', '09H30-10H00', 1, 2),
(7, '2017-12-07', '11H30-12H00', 2, 4),
(8, '2017-12-14', '12H00-12H30', 3, 1),
(9, '2017-12-06', '09H30-10H00', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `username` varchar(63) NOT NULL,
  `password` varchar(63) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`idUser`, `username`, `password`) VALUES
(1, 'narcisse', 'narcisse');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id_medecin`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_patient`);

--
-- Index pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `id_rdv` (`id_rdv`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id_medecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
