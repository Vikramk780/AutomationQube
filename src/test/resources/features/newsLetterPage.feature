Feature: On NewLetter page we will verify doing subscription and checking success msg

  in this i visit newsletter page
  i select subscription
  then i check success msg after updating subscription

  Background:
    Given user has already logged in to application
      | username                          | password   |
      | kvikramautomationtesting@gmail.com | Test@1234  |

  Scenario: verify updating subscription and update success msg
    Given i visit newsletter page
    When i update the subscription
    Then i verify success msg after update of subscription