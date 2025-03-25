Feature: On this page we will verify functionalities related to address book

  Background:
    Given user has already logged in to application
      | username                           | password   |
      | kvikramautomationtesting@gmail.com | Test@1234  |

  Scenario: Verify visiting the Address Book Entries page and creating a new address

    Given I navigate to the Address Book Entries page
    When I verify that the Address Book Entries page opens successfully
    Then I create a new address and confirm its successful creation


    Scenario: Delete all address present
    Given I navigate to the Address Book Entries page
    When I verify that the Address Book Entries page opens successfully
    Then i delete all addresses present