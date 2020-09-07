-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 10 août 2020 à 04:44
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tp2`
--

-- --------------------------------------------------------

--
-- Structure de la table `invitation`
--

CREATE TABLE `invitation` (
  `idinvitation` int(11) NOT NULL,
  `idpersonne` int(11) DEFAULT NULL,
  `idprojet` int(11) DEFAULT NULL,
  `description` varchar(250) NOT NULL,
  `reponse` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `invitation`
--

INSERT INTO `invitation` (`idinvitation`, `idpersonne`, `idprojet`, `description`, `reponse`) VALUES
(1, 1, 4, 'participer avec nous', 1),
(2, 1, 3, 'fais partie de notre equipe', 1),
(3, 3, 2, 'viens viens', 0),
(4, 2, 4, 'rejoigner nous', 0),
(5, 3, 2, 'rejoigner nous 2', 0),
(6, 4, 1, 'rejoigner nous 3', 0);

-- --------------------------------------------------------

--
-- Structure de la table `membres`
--

CREATE TABLE `membres` (
  `idmembre` int(11) NOT NULL,
  `idpersonne` int(11) DEFAULT NULL,
  `idprojet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `membres`
--

INSERT INTO `membres` (`idmembre`, `idpersonne`, `idprojet`) VALUES
(1, 1, 2),
(2, 1, 1),
(6, 1, 3),
(7, 2, 3);


-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `idpersonne` int(11) NOT NULL,
  `nom` varchar(60) NOT NULL,
  `prenom` varchar(60) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `motdepass` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`idpersonne`, `nom`, `prenom`, `email`, `motdepass`) VALUES
(1, 'elkhomsi', 'mohamed', 'elkhomsi.mohamed@gmail.com', '123456'),
(2, 'bouali', 'rachid', 'rachid@gmail.com', 'abcdef'),
(3, 'belarbia', 'ali', 'ali@gmail.com', 'abc123'),
(4, 'gibbawi', 'youssef', 'youssef@gmail.com', '123abc'),
(5, 'toto', 'nono', '111@111.com', '111'),
(6, 'flouflou', 'Froufrou', 'froufrou@froufrou.com', '1234'),
(7, 'glouglou', 'grougrou', 'grougrou@froufrou.com', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `idprojet` int(11) NOT NULL,
  `nom` varchar(60) NOT NULL,
  `description` varchar(250) NOT NULL,
  `idpersonne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`idprojet`, `nom`, `description`, `idpersonne`) VALUES
(1, 'projet android', 'developper des activites', 1),
(2, 'projet java', 'developper application desktop', 2),
(3, 'projet javascript', 'developper un script', 3),
(4, 'project c#', 'developper WCF', 4),
(5, 'projet Angular', 'creer un client Angular', 1),
(6, 'Projet Service REST', 'Creer un service REST', 6),
(7, 'Projet Service SOAP', 'Creer un service SOAP', 7);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD PRIMARY KEY (`idinvitation`),
  ADD KEY `idpersonne` (`idpersonne`),
  ADD KEY `idprojet` (`idprojet`);

--
-- Index pour la table `membres`
--
ALTER TABLE `membres`
  ADD PRIMARY KEY (`idmembre`),
  ADD KEY `idpersonne` (`idpersonne`),
  ADD KEY `idprojet` (`idprojet`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idpersonne`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`idprojet`),
  ADD KEY `idpersonne` (`idpersonne`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `invitation`
--
ALTER TABLE `invitation`
  MODIFY `idinvitation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `membres`
--
ALTER TABLE `membres`
  MODIFY `idmembre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idpersonne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `idprojet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD CONSTRAINT `invitation_ibfk_1` FOREIGN KEY (`idpersonne`) REFERENCES `personne` (`idpersonne`),
  ADD CONSTRAINT `invitation_ibfk_2` FOREIGN KEY (`idprojet`) REFERENCES `projet` (`idprojet`);

--
-- Contraintes pour la table `membres`
--
ALTER TABLE `membres`
  ADD CONSTRAINT `membres_ibfk_1` FOREIGN KEY (`idpersonne`) REFERENCES `personne` (`idpersonne`),
  ADD CONSTRAINT `membres_ibfk_2` FOREIGN KEY (`idprojet`) REFERENCES `projet` (`idprojet`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`idpersonne`) REFERENCES `personne` (`idpersonne`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
