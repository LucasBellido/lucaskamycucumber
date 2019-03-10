Feature: Email

  Scenario: Sending an email after attaching an image
    Given I am on the Gmail main page
    When I press "Compose"
    And Enter a valid recipient
    And Attach an Image
    Then I should be able to press "Send"


