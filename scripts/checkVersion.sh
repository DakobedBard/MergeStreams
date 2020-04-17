#!/bin/bash
function check_cli_v2() {

  if [[ -z $(confluent version | grep "Go") ]]; then
    echo "This demo requires the new Confluent CLI. Please update your version and try again."
    exit 1
  fi

  return 0
}