import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './user-info.reducer';
import { IUserInfo } from 'app/shared/model/user-info.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IUserInfoDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class UserInfoDetail extends React.Component<IUserInfoDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { userInfoEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="ecoLearningApp.userInfo.detail.title">UserInfo</Translate> [<b>{userInfoEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="phone">
                <Translate contentKey="ecoLearningApp.userInfo.phone">Phone</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.phone}</dd>
            <dt>
              <span id="classLevel">
                <Translate contentKey="ecoLearningApp.userInfo.classLevel">Class Level</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.classLevel}</dd>
            <dt>
              <span id="school">
                <Translate contentKey="ecoLearningApp.userInfo.school">School</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.school}</dd>
            <dt>
              <span id="location">
                <Translate contentKey="ecoLearningApp.userInfo.location">Location</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.location}</dd>
            <dt>
              <span id="gender">
                <Translate contentKey="ecoLearningApp.userInfo.gender">Gender</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.gender}</dd>
            <dt>
              <span id="dateofbirth">
                <Translate contentKey="ecoLearningApp.userInfo.dateofbirth">Dateofbirth</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={userInfoEntity.dateofbirth} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="device">
                <Translate contentKey="ecoLearningApp.userInfo.device">Device</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.device}</dd>
            <dt>
              <span id="deviceToken">
                <Translate contentKey="ecoLearningApp.userInfo.deviceToken">Device Token</Translate>
              </span>
            </dt>
            <dd>{userInfoEntity.deviceToken}</dd>
            <dt>
              <Translate contentKey="ecoLearningApp.userInfo.userinforls">Userinforls</Translate>
            </dt>
            <dd>{userInfoEntity.userinforlsLogin ? userInfoEntity.userinforlsLogin : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/user-info" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/user-info/${userInfoEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ userInfo }: IRootState) => ({
  userInfoEntity: userInfo.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(UserInfoDetail);
