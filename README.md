# FI-BREW

[![FIWARE Core Context Management]( https://img.shields.io/badge/FIWARE-IoT_Agent-45d3dd.svg)](https://www.fiware.org/developers/catalogue/)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-green)](https://opensource.org/licenses/MIT)
[![Documentation Status](https://readthedocs.org/projects/feats/badge/?version=latest)](https://fi-brew-dih2.readthedocs.io/en/latest/?badge=latest)
 [![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/4844/badge)](https://bestpractices.coreinfrastructure.org/projects/4844)

FI-BREW is a component of the FEATS project.
This component is responsible for sending work order information to an automatic warehouse (manufactured by Modula), by writing the required material and quantity into the warehouse database.

This project is part of [DIH^2](http://www.dih-squared.eu/). For more information check the RAMP Catalogue entry for the
[components](https://github.com/ramp-eu).

This project is part of [FIWARE](https://www.fiware.org/). For more information check the [FIWARE Catalogue](https://github.com/Fiware/catalogue/).

## Contents

- [FI-BREW](#fi-brew)
  - [Contents](#contents)
  - [Background](#background)
  - [Build & Install](#build--install)
  - [API Overview](#api-overview)
  - [Documentation](#documentation)
  - [License](#license)

## Background
Fiware-Enabled Autonomous Transport System (FEATS) is a project whose scope is the automated  transport of material within a production facility using an Autonomous Mobile Robot (AMR). This component - FI-BREW - is responsible for receiving work order information from [LATTE](https://github.com/Dalma-Systems/latte), using the [Orion Context Broker](https://fiware-orion.readthedocs.io/en/master/)), and sending it to an automatic warehouse, through the writing of material information into an SQL database. 
[Orion](https://fiware-orion.readthedocs.io/en/master/) is a context broker that works in a publish/subscribe mechanism. This broker is part of the [FIWARE](https://www.fiware.org/) platform.

## Build & Install
Information about how to install the components of FEATS can be found in the corresponding section of the Read The Docs [page](https://fi-brew-dih2.readthedocs.io/en/latest/).

## API Overview
An example of the usage of the system can be found in the corresponding section of the Read The Docs [page](https://fi-brew-dih2.readthedocs.io/en/latest/).

## Documentation
All documentation is available in `docs` folder. Check [documentation index](docs/index.md) to get all the information about the system architecture and API, and also about how to install and test the application.

## License
[Apache](LICENSE) © 2021 Dalma Systems