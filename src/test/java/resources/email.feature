Feature: Email

  Scenario: Sending an email after attaching an image
    Given I am on the Gmail main page
    When I press "Compose"
    And Enter a valid recipient
    And Attach an Image
    Then I should be able to press "Send"
    And The message successfully sends

  Scenario: Sending an email from drafts
    Given I am on the Gmail main page
    When I press "Draft"
    And a previous draft of my valid email exists
    Then I should be able to press "Send"
    And The message successfully sends



