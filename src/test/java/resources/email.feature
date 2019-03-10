Feature: Email

  Scenario: Sending an email after attaching an image
    Given I am on the Gmail main page
    When I press "Compose"
    And Attach an Image
    And Enter a valid recipient
    Then I should be able to press "Send"
    And A "Message Sent" popup exists
