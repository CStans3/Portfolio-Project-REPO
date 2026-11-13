# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [0.1.0] - [2026.11.11]

### Added

- Completed Part 1 component brainstorming.

- Designed three possible components: Game Inventory,
  Quest Tracker, and Character Stat Sheet.

### Removed

- Removed TODO sections found in 01-component-brainstorming.md file

### Changed

- repurposed template CHANGELOG.md to better suit my implementation of this project.

## [0.2.0] - [2026.11.11]

### Added

- Selected Character Stat Sheet for the portfolio project.

- Created the CharacterStatSheet Java proof-of-concept.

- Added representation fields for current health,
  maximum health, attack, and defense.

- Implemented getter and setter methods for character
  statistics.

- Added methods for taking damage, healing, checking
  whether a character is alive, and calculating
  missing health.

- Added a method for displaying character statistics
  using the OSU SimpleWriter component.

- Created an interactive demonstration using
  SimpleReader and SimpleWriter.

- Documented the component selection, implementation,
  and design decisions for Part 2.

## [0.2.1] - [2026.11.12]

### Added

- Published new branch and pushed pending changes.

## [0.3.0] - [2026.11.12]

### Added

- Created CharacterStatSheetKernel interface.

- Created CharacterStatSheet enhanced interface.

- Added mathematical model and representation invariants.

- Added Javadoc contracts for all interface methods.

- Designed the component hierarchy diagram.

### Changed

- Separated kernel and secondary operations.

- Removed console input and output from the component API.

- Changed CharacterStatSheet from a proof-of-concept
  class into an enhanced interface.

- Defined default character statistics for the
  Standard component implementation.

## [0.4.0] - [2026.11.12]

### Added

- Implemented CharacterStatSheetSecondary abstract class.

- Implemented takeDamage, heal, isAlive, and healthMissing
  using only kernel methods.

- Added toString to display character statistics.

- Added equals to compare two character stat sheets.

- Added hashCode consistent with equals.

- Added Javadoc and logical block comments.

### Changed

- Moved secondary method implementations into the
  abstract class instead of the concrete representation.

- Added precondition checks for damage and healing.

- Updated the design to keep secondary methods
  independent of representation fields.

## [0.4.1] - [2026.11.12]

### Changed

- Added versions to the formatting of the changelog, found from [Calendar Versioning](https://calver.org/).
- Additionally rearranged sections of changelog to properly represent meaningful changes.

## [0.5.0] - [2026.11.13]

### Added

- kernel-implementation branch
- CharacterStatSheet1L.java
- constants to be used later
- part 5 pre-assignment reflection

### Changed

- swapped from using `int` primitives in design to using `Sequence<Integer>` to fulfill data structure requirement

## [0.5.1] - [2026.11.13]

### Added

-